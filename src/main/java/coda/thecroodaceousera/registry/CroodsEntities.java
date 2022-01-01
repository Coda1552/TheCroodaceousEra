package coda.thecroodaceousera.registry;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.common.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Croods.MOD_ID);

    public static final RegistryObject<EntityType<JackrobatEntity>> JACKROBAT = create("jackrobat", EntityType.Builder.of(JackrobatEntity::new, EntityClassification.CREATURE).sized(0.4f, 0.4f));
    public static final RegistryObject<EntityType<LiyoteEntity>> LIYOTE = create("liyote", EntityType.Builder.of(LiyoteEntity::new, EntityClassification.CREATURE).sized(0.7f, 0.8f));
    //public static final RegistryObject<EntityType<BaobabBoatEntity>> BAOBAB_BOAT = create("baobab_boat", EntityType.Builder.create(BaobabBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).trackingRange(10));
    public static final RegistryObject<EntityType<MousephantEntity>> MOUSEPHANT = create("mousephant", EntityType.Builder.of(MousephantEntity::new, EntityClassification.CREATURE).sized(0.4f, 0.3f));
    public static final RegistryObject<EntityType<MosquitoEntity>> MOSQUITO = create("mosquito", EntityType.Builder.of(MosquitoEntity::new, EntityClassification.CREATURE).sized(0.8f, 0.8f));
    public static final RegistryObject<EntityType<BearOwlEntity>> BEAR_OWL = create("bear_owl",EntityType.Builder.of(BearOwlEntity::new, EntityClassification.CREATURE).sized(1.5f, 1.5f));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return REGISTER.register(name, () -> builder.build(Croods.MOD_ID + "." + name));
    }
}