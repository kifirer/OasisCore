package net.mcreator.oasiscore.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.oasiscore.OasiscoreModElements;
import net.mcreator.oasiscore.OasiscoreMod;

import java.util.Map;

@OasiscoreModElements.ModElement.Tag
public class IridiumSwordCompleteLivingEntityIsHitWithToolProcedure extends OasiscoreModElements.ModElement {
	public IridiumSwordCompleteLivingEntityIsHitWithToolProcedure(OasiscoreModElements instance) {
		super(instance, 92);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency entity for procedure IridiumSwordCompleteLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				OasiscoreMod.LOGGER.warn("Failed to load dependency sourceentity for procedure IridiumSwordCompleteLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
					+ (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
							- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))));
	}
}
