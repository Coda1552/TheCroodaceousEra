package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.entity.JackrobatEntity;
import mod.coda.croodaceouscraft.entity.LiyoteEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Croods.MOD_ID);

    public static final RegistryObject<EntityType<JackrobatEntity>> JACKROBAT = create("jackrobat", EntityType.Builder.create(JackrobatEntity::new, EntityClassification.CREATURE).size(0.4f, 0.4f));
    public static final RegistryObject<EntityType<LiyoteEntity>> LIYOTE = create("liyote", EntityType.Builder.create(LiyoteEntity::new, EntityClassification.CREATURE).size(0.7f, 0.8f));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return REGISTER.register(name, () -> builder.build(Croods.MOD_ID + "." + name));
    }
}