
package net.mcreator.oasiscore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.oasiscore.itemgroup.OasisCoreTabItemGroup;
import net.mcreator.oasiscore.OasiscoreModElements;

@OasiscoreModElements.ModElement.Tag
public class RhodiumAxeItem extends OasiscoreModElements.ModElement {
	@ObjectHolder("oasiscore:rhodium_axe")
	public static final Item block = null;
	public RhodiumAxeItem(OasiscoreModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1212;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 16f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(RhodiumIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(OasisCoreTabItemGroup.tab)) {
		}.setRegistryName("rhodium_axe"));
	}
}
