package net.mcreator.oasiscore.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.oasiscore.enchantment.EnchantDamageDelayEnchantment;
import net.mcreator.oasiscore.OasiscoreModElements;
import net.mcreator.oasiscore.OasiscoreMod;

import java.util.Map;
import java.util.HashMap;

@OasiscoreModElements.ModElement.Tag
public class ProcedureEnchantDamageDelayProcedure extends OasiscoreModElements.ModElement {
	public ProcedureEnchantDamageDelayProcedure(OasiscoreModElements instance) {
		super(instance, 96);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency entity for procedure ProcedureEnchantDamageDelay!");
			return;
		}
		if (dependencies.get("imediatesourceentity") == null) {
			if (!dependencies.containsKey("imediatesourceentity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency imediatesourceentity for procedure ProcedureEnchantDamageDelay!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency world for procedure ProcedureEnchantDamageDelay!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity imediatesourceentity = (Entity) dependencies.get("imediatesourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((EnchantmentHelper.getEnchantmentLevel(EnchantDamageDelayEnchantment.enchantment,
				((imediatesourceentity instanceof LivingEntity)
						? ((LivingEntity) imediatesourceentity).getHeldItemMainhand()
						: ItemStack.EMPTY)) != 0))
				|| ((EnchantmentHelper.getEnchantmentLevel(EnchantDamageDelayEnchantment.enchantment,
						((imediatesourceentity instanceof LivingEntity)
								? ((LivingEntity) imediatesourceentity).getHeldItemOffhand()
								: ItemStack.EMPTY)) != 0)))) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 4.5);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 90);
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
