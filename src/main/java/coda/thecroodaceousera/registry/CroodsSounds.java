package coda.thecroodaceousera.registry;

import coda.thecroodaceousera.Croods;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class    CroodsSounds {
    public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Croods.MOD_ID);

    public static final RegistryObject<SoundEvent> MOUSEPHANT_AMBIENT = REGISTER.register("mousephant_ambient", () -> new SoundEvent(new ResourceLocation(Croods.MOD_ID, "mousephant.ambient")));
    public static final RegistryObject<SoundEvent> MOUSEPHANT_HURT = REGISTER.register("mousephant_hurt", () -> new SoundEvent(new ResourceLocation(Croods.MOD_ID, "mousephant.hurt")));
    public static final RegistryObject<SoundEvent> MOUSEPHANT_DEATH = REGISTER.register("mousephant_death", () -> new SoundEvent(new ResourceLocation(Croods.MOD_ID, "mousephant.death")));
    public static final RegistryObject<SoundEvent> MOUSEPHANT_TRUMPET = REGISTER.register("mousephant_trumpet", () -> new SoundEvent(new ResourceLocation(Croods.MOD_ID, "mousephant.trumpet")));
}
