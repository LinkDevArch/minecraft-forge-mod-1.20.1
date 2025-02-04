package net.johan.firstmod.event;


import net.johan.firstmod.FirstMod;
import net.johan.firstmod.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event) {

        //FOV MODIFIER WHEN USING GOD BOW

        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ModItems.GODBOW.get()){
            float fovModifier = 1f;
            int tickUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaticks = (float)tickUsingItem / 20f;
            if (deltaticks > 1f) {
                deltaticks = 1f;
            } else {
                deltaticks *= deltaticks;
            }
            fovModifier *= 1f - deltaticks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }

    }
}
