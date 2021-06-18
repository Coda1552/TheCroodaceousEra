package coda.thecroodaceousera.entity;

import coda.thecroodaceousera.init.CroodsItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class JackrobatEntity extends AnimalEntity implements IFlyingAnimal {
    public static final DataParameter<Boolean> FLYING = EntityDataManager.defineId(JackrobatEntity.class, DataSerializers.BOOLEAN);

    public JackrobatEntity(EntityType<? extends JackrobatEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveControl = new FlyingMovementController(this, 20, true);
        this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
        this.setPathfindingMalus(PathNodeType.WATER_BORDER, 16.0F);
    }

    public float getWalkTargetValue(BlockPos pos, IWorldReader worldIn) {
        return worldIn.getBlockState(pos).isAir() ? 10.0F : 0.0F;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new JackrobatEntity.WanderGoal());
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
    }

    protected PathNavigator createNavigation(World worldIn) {
        FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn) {
            public boolean isStableDestination(BlockPos pos) {
                return !this.level.getBlockState(pos.below()).isAir();
            }
        };
        flyingpathnavigator.setCanOpenDoors(false);
        flyingpathnavigator.setCanFloat(false);
        flyingpathnavigator.setCanPassDoors(true);
        return flyingpathnavigator;
    }

    public boolean causeFallDamage(float distance, float damageMultiplier) {
        return false;
    }

    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.FLYING_SPEED, 0.55D);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.BAT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BAT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BAT_DEATH;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public CowEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.3F;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(CroodsItems.JACKROBAT_SPAWN_EGG.get());
    }

    class WanderGoal extends Goal {
        WanderGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return JackrobatEntity.this.navigation.isDone() && JackrobatEntity.this.random.nextInt(10) == 0;
        }
        
        public boolean canContinueToUse() {
            return JackrobatEntity.this.navigation.isInProgress();
        }
        
        public void start() {
            Vector3d vector3d = this.getRandomLocation();
            if (vector3d != null) {
                JackrobatEntity.this.navigation.moveTo(JackrobatEntity.this.navigation.createPath(new BlockPos(vector3d), 1), 1.0D);
            }
        }

        @Nullable
        private Vector3d getRandomLocation() {
            Vector3d vector3d;
            vector3d = JackrobatEntity.this.getViewVector(0.0F);

            int i = 8;
            Vector3d vector3d2 = RandomPositionGenerator.getAboveLandPos(JackrobatEntity.this, 8, 7, vector3d, ((float)Math.PI / 2F), 2, 1);
            return vector3d2 != null ? vector3d2 : RandomPositionGenerator.getAirPos(JackrobatEntity.this, 8, 4, -2, vector3d, (double)((float)Math.PI / 2F));
        }
    }
}
