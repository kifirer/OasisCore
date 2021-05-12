
package net.mcreator.oasiscore.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.oasiscore.block.OsniumBlockBlock;
import net.mcreator.oasiscore.OasiscoreModElements;

@OasiscoreModElements.ModElement.Tag
public class OasisCoreTabItemGroup extends OasiscoreModElements.ModElement {
	public OasisCoreTabItemGroup(OasiscoreModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("taboasis_core_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OsniumBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
