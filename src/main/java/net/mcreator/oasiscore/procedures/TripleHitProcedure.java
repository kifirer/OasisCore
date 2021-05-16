package net.mcreator.oasiscore.procedures;

@OasiscoreModElements.ModElement.Tag
public class TripleHitProcedure extends OasiscoreModElements.ModElement {

	public TripleHitProcedure(OasiscoreModElements instance) {
		super(instance, 100);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency entity for procedure TripleHit!");
			return;
		}
		if (dependencies.get("imediatesourceentity") == null) {
			if (!dependencies.containsKey("imediatesourceentity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency imediatesourceentity for procedure TripleHit!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency world for procedure TripleHit!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		Entity imediatesourceentity = (Entity) dependencies.get("imediatesourceentity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((((EnchantmentHelper.getEnchantmentLevel(EnchantTripleHitEnchantment.enchantment,
				((imediatesourceentity instanceof LivingEntity)
						? ((LivingEntity) imediatesourceentity).getHeldItemOffhand()
						: ItemStack.EMPTY)) != 0))
				|| ((EnchantmentHelper.getEnchantmentLevel(EnchantTripleHitEnchantment.enchantment,
						((imediatesourceentity instanceof LivingEntity)
								? ((LivingEntity) imediatesourceentity).getHeldItemMainhand()
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
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 7);
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
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 7);
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
									entity.attackEntityFrom(DamageSource.GENERIC, (float) 7);
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
											entity.attackEntityFrom(DamageSource.GENERIC, (float) 7);

											MinecraftForge.EVENT_BUS.unregister(this);
										}

									}.start(world, (int) 2);

									MinecraftForge.EVENT_BUS.unregister(this);
								}

							}.start(world, (int) 2);

							MinecraftForge.EVENT_BUS.unregister(this);
						}

					}.start(world, (int) 2);

					MinecraftForge.EVENT_BUS.unregister(this);
				}

			}.start(world, (int) 2);
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
