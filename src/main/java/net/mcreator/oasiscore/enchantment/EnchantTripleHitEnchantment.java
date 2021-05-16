
package net.mcreator.oasiscore.enchantment;

@OasiscoreModElements.ModElement.Tag
public class EnchantTripleHitEnchantment extends OasiscoreModElements.ModElement {

	@ObjectHolder("oasiscore:enchant_triple_hit")
	public static final Enchantment enchantment = null;

	public EnchantTripleHitEnchantment(OasiscoreModElements instance) {
		super(instance, 99);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("enchant_triple_hit"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.WEAPON, slots);
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
