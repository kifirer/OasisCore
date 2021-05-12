package net.mcreator.oasiscore.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.oasiscore.enchantment.EnchantXpHealingEnchantment;
import net.mcreator.oasiscore.OasiscoreModElements;
import net.mcreator.oasiscore.OasiscoreMod;

import java.util.Map;
import java.util.HashMap;

@OasiscoreModElements.ModElement.Tag
public class ProcedureEnchantment1Procedure extends OasiscoreModElements.ModElement {
	public ProcedureEnchantment1Procedure(OasiscoreModElements instance) {
		super(instance, 22);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency entity for procedure ProcedureEnchantment1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((EnchantmentHelper.getEnchantmentLevel(EnchantXpHealingEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY)) != 0))
				|| (((EnchantmentHelper.getEnchantmentLevel(EnchantXpHealingEnchantment.enchantment,
						((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
								: ItemStack.EMPTY)) != 0))
						|| (((EnchantmentHelper.getEnchantmentLevel(EnchantXpHealingEnchantment.enchantment,
								((entity instanceof LivingEntity)
										? ((LivingEntity) entity)
												.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
										: ItemStack.EMPTY)) != 0))
								|| (((EnchantmentHelper.getEnchantmentLevel(EnchantXpHealingEnchantment.enchantment,
										((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getItemStackFromSlot(
														EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
												: ItemStack.EMPTY)) != 0))
										|| (((EnchantmentHelper.getEnchantmentLevel(EnchantXpHealingEnchantment.enchantment,
												((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY)) != 0))
												|| ((EnchantmentHelper.getEnchantmentLevel(EnchantXpHealingEnchantment.enchantment,
														((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemOffhand()
																: ItemStack.EMPTY)) != 0)))))))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
						+ (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) / 4)));
		}
	}

	@SubscribeEvent
	public void onPlayerXPChange(PlayerXpEvent.XpChange event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			int amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("amount", amount);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
