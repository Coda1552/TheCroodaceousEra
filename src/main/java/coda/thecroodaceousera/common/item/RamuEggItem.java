package coda.thecroodaceousera.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RamuEggItem extends Item {

    public RamuEggItem(Item.Properties p_i225737_1_) {
        super(p_i225737_1_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack p_77654_1_, World p_77654_2_, LivingEntity p_77654_3_) {
        super.finishUsingItem(p_77654_1_, p_77654_2_, p_77654_3_);

        if (p_77654_3_.level.isClientSide) {
            showParticles(p_77654_3_, 5);
        }

        if (p_77654_3_ instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) p_77654_3_;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, p_77654_1_);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
        }
        return p_77654_1_;
    }

    @Override
    public int getUseDuration(ItemStack p_77626_1_) {
        return 40;
    }

    @Override
    public UseAction getUseAnimation(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return DrinkHelper.useDrink(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    @OnlyIn(Dist.CLIENT)
    private static void showParticles(Entity p_226932_0_, int p_226932_1_) {
        if (p_226932_0_.level.isClientSide) {
            BlockState blockstate = Blocks.HONEY_BLOCK.defaultBlockState();

            for(int i = 0; i < p_226932_1_; ++i) {
                p_226932_0_.level.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate), p_226932_0_.getX(), p_226932_0_.getY() + 0.75F, p_226932_0_.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }
}