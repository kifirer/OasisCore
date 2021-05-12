package net.mcreator.oasiscore.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Block;

import net.mcreator.oasiscore.enchantment.EnchantFallDamage1Enchantment;
import net.mcreator.oasiscore.OasiscoreModElements;
import net.mcreator.oasiscore.OasiscoreMod;

import java.util.Map;
import java.util.HashMap;

@OasiscoreModElements.ModElement.Tag
public class ProcedureEnchantFallDamage1Procedure extends OasiscoreModElements.ModElement {
	public ProcedureEnchantFallDamage1Procedure(OasiscoreModElements instance) {
		super(instance, 83);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency entity for procedure ProcedureEnchantFallDamage1!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency x for procedure ProcedureEnchantFallDamage1!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency y for procedure ProcedureEnchantFallDamage1!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency z for procedure ProcedureEnchantFallDamage1!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency world for procedure ProcedureEnchantFallDamage1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((((EnchantmentHelper.getEnchantmentLevel(EnchantFallDamage1Enchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY)) != 0))
				&& (entity.isSneaking())) && (entity instanceof PlayerEntity))) {
			entity.fallDistance = (float) (0);
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 1), (int) (entity.getPosZ()))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 1), (int) (entity.getPosZ())), false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(new BlockPos((int) ((entity.getPosX()) - 1), (int) ((entity.getPosY()) - 1), (int) (entity.getPosZ()))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) ((entity.getPosX()) - 1), (int) ((entity.getPosY()) - 1), (int) (entity.getPosZ())), false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(new BlockPos((int) ((entity.getPosX()) + 1), (int) ((entity.getPosY()) - 1), (int) (entity.getPosZ()))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) ((entity.getPosX()) + 1), (int) ((entity.getPosY()) - 1), (int) (entity.getPosZ())), false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(
								new BlockPos((int) ((entity.getPosX()) + 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) + 1))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) ((entity.getPosX()) + 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) + 1)),
						false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(
								new BlockPos((int) ((entity.getPosX()) + 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) - 1))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) ((entity.getPosX()) + 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) - 1)),
						false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(
								new BlockPos((int) ((entity.getPosX()) - 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) + 1))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) ((entity.getPosX()) - 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) + 1)),
						false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(
								new BlockPos((int) ((entity.getPosX()) - 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) - 1))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) ((entity.getPosX()) - 1), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) - 1)),
						false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) - 1))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) - 1)), false);
			}
			if (world instanceof World) {
				Block.spawnDrops(
						world.getBlockState(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) + 1))),
						(World) world, new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) + 1)), false);
			}
		}
	}

	@SubscribeEvent
	public void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double damagemultiplier = event.getDamageMultiplier();
			double distance = event.getDistance();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("damagemultiplier", damagemultiplier);
			dependencies.put("distance", distance);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
