
package net.mcreator.oasiscore.enchantment;

@OasiscoreModElements.ModElement.Tag
public class EnchantEveryonesPoisonEnchantment extends OasiscoreModElements.ModElement {

	@ObjectHolder("oasiscore:enchant_everyones_poison")
	public static final Enchantment enchantment = null;

	public EnchantEveryonesPoisonEnchantment(OasiscoreModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("enchant_everyones_poison"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

	}

}
