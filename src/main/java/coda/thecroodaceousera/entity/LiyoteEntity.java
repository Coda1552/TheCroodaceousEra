package coda.thecroodaceousera.entity;

import coda.thecroodaceousera.init.CroodsBlocks;
import coda.thecroodaceousera.init.CroodsItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class LiyoteEntity extends TameableEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.defineId(LiyoteEntity.class, DataSerializers.INT);
    private static final Predicate<ItemEntity> TRUSTED_TARGET_SELECTOR = (p_213489_0_) -> {
        return !p_213489_0_.hasPickUpDelay() && p_213489_0_.isAlive();
    };
    private int groupSize = 8;
    private float interestedAngle;

    public LiyoteEntity(EntityType<? extends LiyoteEntity> type, World worldIn) {
        super(type, worldIn);
        this.setCanPickUpLoot(true);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new SitGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PlayerEntity.class, 10.0F, 1.8D, 1.6D, EntityPredicates.NO_SPECTATORS::test));
        this.goalSelector.addGoal(4, new LiyoteEntity.FindItemsGoal());
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, (double)0.25F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOLF_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WOLF_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }

    public static boolean checkLiyoteSpawnRules(EntityType<? extends LiyoteEntity> p_223316_0_, IWorld p_223316_1_, SpawnReason p_223316_2_, BlockPos p_223316_3_, Random rand) {
        return p_223316_1_.getBlockState(p_223316_3_.below()).is(CroodsBlocks.CROODACEOUS_SAND.get()) && p_223316_1_.getRawBrightness(p_223316_3_, 0) > 8 && rand.nextFloat() > 0.95F;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    private void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", getVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        setVariant(compound.getInt("Variant"));
    }

    public void setTame(boolean tamed) {
        super.setTame(tamed);
        if (tamed) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(16.0D);
            this.setHealth(16.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
        }
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item == CroodsItems.RAMU_EGG.get() && !this.isTame()) {
            if (!player.abilities.instabuild) {
                stack.shrink(1);
            }
            if (!ForgeEventFactory.onAnimalTame(this, player)) {
                this.tame(player);
                this.navigation.stop();
                this.setOrderedToSit(true);
                this.level.broadcastEntityEvent(this, (byte) 7);
            } else {
                this.level.broadcastEntityEvent(this, (byte) 6);
            }
            return ActionResultType.SUCCESS;
        }

        if (this.isOwnedBy(player)) {
            setOrderedToSit(!isInSittingPose());
            this.jumping = false;
            this.navigation.stop();
            }
        return super.mobInteract(player, hand);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 45) {
            ItemStack itemstack = this.getItemBySlot(EquipmentSlotType.MAINHAND);
            if (!itemstack.isEmpty()) {
                for(int i = 0; i < 8; ++i) {
                    Vector3d vector3d = (new Vector3d(((double)this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).xRot(-this.xRot * ((float)Math.PI / 180F)).yRot(-this.yRot * ((float)Math.PI / 180F));
                    this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, itemstack), this.getX() + this.getLookAngle().x / 2.0D, this.getY(), this.getZ() + this.getLookAngle().z / 2.0D, vector3d.x, vector3d.y + 0.05D, vector3d.z);
                }
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
    }

    public boolean canTakeItem(ItemStack itemstackIn) {
        EquipmentSlotType equipmentslottype = MobEntity.getEquipmentSlotForItem(itemstackIn);
        if (!this.getItemBySlot(equipmentslottype).isEmpty() && this.isTame()) {
            return false;
        }
        else {
            return equipmentslottype == EquipmentSlotType.MAINHAND && super.canTakeItem(itemstackIn);
        }
    }

    public boolean canHoldItem(ItemStack stack) {
        Item item = stack.getItem();
        ItemStack itemstack = this.getItemBySlot(EquipmentSlotType.MAINHAND);
        return itemstack.isEmpty() && item.isEdible();
    }

    private void spitOutItem(ItemStack stackIn) {
        if (!stackIn.isEmpty() && !this.level.isClientSide) {
            ItemEntity itementity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, stackIn);
            itementity.setPickUpDelay(40);
            itementity.setThrower(this.getUUID());
            this.playSound(SoundEvents.FOX_SPIT, 1.0F, 1.0F);
            this.level.addFreshEntity(itementity);
        }
        else if (!stackIn.isEmpty() && !this.level.isClientSide && this.getKillCredit() instanceof PlayerEntity) {
            ItemEntity itementity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, stackIn);
            itementity.setPickUpDelay(40);
            itementity.setThrower(this.getUUID());
            this.playSound(SoundEvents.FOX_SPIT, 1.0F, 1.0F);
            this.level.addFreshEntity(itementity);
        }
    }

    private void spawnItem(ItemStack stackIn) {
        ItemEntity itementity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stackIn);
        this.level.addFreshEntity(itementity);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(CroodsItems.LIYOTE_SPAWN_EGG.get());
    }

    @Override
    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack itemstack = itemEntity.getItem();
        if (this.canHoldItem(itemstack)) {
            int i = itemstack.getCount();
            if (i > 1) {
                this.spawnItem(itemstack.split(i - 1));
            }

            this.spitOutItem(this.getItemBySlot(EquipmentSlotType.MAINHAND));
            this.onItemPickup(itemEntity);
            this.setItemSlot(EquipmentSlotType.MAINHAND, itemstack.split(1));
            this.handDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
            this.take(itemEntity, itemstack.getCount());
            itemEntity.remove();
        }

    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        if (spawnDataIn == null) {
            if (random.nextDouble() > 0.95) setVariant(1);
            else {
                setVariant(0);
            }
        }

        return spawnDataIn;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    class FindItemsGoal extends Goal {
        public FindItemsGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (!LiyoteEntity.this.getItemBySlot(EquipmentSlotType.MAINHAND).isEmpty()) {
                return false;
            }
            else if (LiyoteEntity.this.getTarget() == null && LiyoteEntity.this.getLastHurtByMob() == null && !LiyoteEntity.this.isTame()) {
                if (LiyoteEntity.this.getRandom().nextInt(10) != 0) {
                    return false;
                }
                else {
                    List<ItemEntity> list = LiyoteEntity.this.level.getEntitiesOfClass(ItemEntity.class, LiyoteEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), LiyoteEntity.TRUSTED_TARGET_SELECTOR);
                    return !list.isEmpty() && LiyoteEntity.this.getItemBySlot(EquipmentSlotType.MAINHAND).isEmpty();
                }
            }
            else {
                return false;
            }
        }

        public void tick() {
            List<ItemEntity> list = LiyoteEntity.this.level.getEntitiesOfClass(ItemEntity.class, LiyoteEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), LiyoteEntity.TRUSTED_TARGET_SELECTOR);
            ItemStack itemstack = LiyoteEntity.this.getItemBySlot(EquipmentSlotType.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                LiyoteEntity.this.getNavigation().moveTo(list.get(0), (double)1.2F);
            }
        }

        public void start() {
            List<ItemEntity> list = LiyoteEntity.this.level.getEntitiesOfClass(ItemEntity.class, LiyoteEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), LiyoteEntity.TRUSTED_TARGET_SELECTOR);
            if (!list.isEmpty()) {
                LiyoteEntity.this.getNavigation().moveTo(list.get(0), (double)1.2F);
            }
        }
    }
}
