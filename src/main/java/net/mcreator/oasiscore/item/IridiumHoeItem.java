
package net.mcreator.oasiscore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.oasiscore.itemgroup.OasisCoreTabItemGroup;
import net.mcreator.oasiscore.OasiscoreModElements;

@OasiscoreModElements.ModElement.Tag
public class IridiumHoeItem extends OasiscoreModElements.ModElement {
	@ObjectHolder("oasiscore:iridium_hoe")
	public static final Item block = null;
	public IridiumHoeItem(OasiscoreModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 754;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 31;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(IridiumItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(OasisCoreTabItemGroup.tab)) {
		}.setRegistryName("iridium_hoe"));
	}
}
