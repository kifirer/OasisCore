
package net.mcreator.oasiscore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.oasiscore.itemgroup.OasisCoreTabItemGroup;
import net.mcreator.oasiscore.OasiscoreModElements;

@OasiscoreModElements.ModElement.Tag
public class IridiumItem extends OasiscoreModElements.ModElement {
	@ObjectHolder("oasiscore:iridium")
	public static final Item block = null;
	public IridiumItem(OasiscoreModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(OasisCoreTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("iridium");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
