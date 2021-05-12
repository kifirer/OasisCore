
package net.mcreator.oasiscore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.oasiscore.procedures.IridiumSwordCompleteLivingEntityIsHitWithToolProcedure;
import net.mcreator.oasiscore.itemgroup.OasisCoreTabItemGroup;
import net.mcreator.oasiscore.OasiscoreModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@OasiscoreModElements.ModElement.Tag
public class IridiumSwordCompleteItem extends OasiscoreModElements.ModElement {
	@ObjectHolder("oasiscore:iridium_sword_complete")
	public static final Item block = null;
	public IridiumSwordCompleteItem(OasiscoreModElements instance) {
		super(instance, 91);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1255;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 35;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(IridiumSwordItem.block, (int) (1)), new ItemStack(IridiumItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(OasisCoreTabItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Bloodlust"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("sourceentity", sourceentity);
					IridiumSwordCompleteLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("iridium_sword_complete"));
	}
}
