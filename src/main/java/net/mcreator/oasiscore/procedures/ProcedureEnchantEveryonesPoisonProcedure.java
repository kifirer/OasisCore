package net.mcreator.oasiscore.procedures;

@OasiscoreModElements.ModElement.Tag
public class ProcedureEnchantEveryonesPoisonProcedure extends OasiscoreModElements.ModElement {

	public ProcedureEnchantEveryonesPoisonProcedure(OasiscoreModElements instance) {
		super(instance, 102);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency entity for procedure ProcedureEnchantEveryonesPoison!");
			return;
		}
		if (dependencies.get("imediatesourceentity") == null) {
			if (!dependencies.containsKey("imediatesourceentity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency imediatesourceentity for procedure ProcedureEnchantEveryonesPoison!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		Entity imediatesourceentity = (Entity) dependencies.get("imediatesourceentity");

		if ((((EnchantmentHelper.getEnchantmentLevel(EnchantEveryonesPoisonEnchantment.enchantment,
				((imediatesourceentity instanceof LivingEntity)
						? ((LivingEntity) imediatesourceentity).getHeldItemOffhand()
						: ItemStack.EMPTY)) != 0))
				|| ((EnchantmentHelper.getEnchantmentLevel(EnchantEveryonesPoisonEnchantment.enchantment,
						((imediatesourceentity instanceof LivingEntity)
								? ((LivingEntity) imediatesourceentity).getHeldItemMainhand()
								: ItemStack.EMPTY)) != 0)))) {
			if ((entity instanceof LivingEntity ? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.UNDEAD) : false)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 600, (int) 5));
			} else {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 600, (int) 5));
			}
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
