package net.mcreator.oasiscore.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.oasiscore.enchantment.EnchantHealthOverHealthEnchantment;
import net.mcreator.oasiscore.OasiscoreModElements;
import net.mcreator.oasiscore.OasiscoreMod;

import java.util.Map;
import java.util.HashMap;

@OasiscoreModElements.ModElement.Tag
public class ProcedureEnchantHealthOverHealthProcedure extends OasiscoreModElements.ModElement {
	public ProcedureEnchantHealthOverHealthProcedure(OasiscoreModElements instance) {
		super(instance, 93);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency entity for procedure ProcedureEnchantHealthOverHealth!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getHealth()
				: -1)) && (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0) > 0))
				&& ((entity instanceof PlayerEntity) && (((EnchantmentHelper.getEnchantmentLevel(EnchantHealthOverHealthEnchantment.enchantment,
						((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
								: ItemStack.EMPTY)) != 0))
						|| (((EnchantmentHelper.getEnchantmentLevel(EnchantHealthOverHealthEnchantment.enchantment,
								((entity instanceof LivingEntity)
										? ((LivingEntity) entity)
												.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
										: ItemStack.EMPTY)) != 0))
								|| (((EnchantmentHelper.getEnchantmentLevel(EnchantHealthOverHealthEnchantment.enchantment,
										((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getItemStackFromSlot(
														EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
												: ItemStack.EMPTY)) != 0))
										|| ((EnchantmentHelper.getEnchantmentLevel(EnchantHealthOverHealthEnchantment.enchantment,
												((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getItemStackFromSlot(
																EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
														: ItemStack.EMPTY)) != 0)))))))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats()
						.setFoodLevel((int) (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0) - 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 1));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
