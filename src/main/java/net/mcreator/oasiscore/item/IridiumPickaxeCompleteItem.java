
package net.mcreator.oasiscore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.oasiscore.itemgroup.OasisCoreTabItemGroup;
import net.mcreator.oasiscore.OasiscoreModElements;

@OasiscoreModElements.ModElement.Tag
public class IridiumPickaxeCompleteItem extends OasiscoreModElements.ModElement {
	@ObjectHolder("oasiscore:iridium_pickaxe_complete")
	public static final Item block = null;
	public IridiumPickaxeCompleteItem(OasiscoreModElements instance) {
		super(instance, 88);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 885;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 35;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(IridiumPickaxeItem.block, (int) (1)), new ItemStack(IridiumItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(OasisCoreTabItemGroup.tab)) {
		}.setRegistryName("iridium_pickaxe_complete"));
	}
}
