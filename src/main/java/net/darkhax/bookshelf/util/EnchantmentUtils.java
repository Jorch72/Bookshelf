/**
 * This class was created by <Darkhax>. It is distributed as part of Bookshelf. You can find
 * the original source here: https://github.com/Darkhax-Minecraft/Bookshelf
 *
 * Bookshelf is Open Source and distributed under the GNU Lesser General Public License version
 * 2.1.
 */
package net.darkhax.bookshelf.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public final class EnchantmentUtils {

    /**
     * Utility classes, such as this one, are not meant to be instantiated. Java adds an
     * implicit public constructor to every class which does not define at lease one
     * explicitly. Hence why this constructor was added.
     */
    private EnchantmentUtils () {

        throw new IllegalAccessError("Utility class");
    }

    /**
     * A check to see if an ItemStack can be enchanted. For this to be true, the ItemStack must
     * have an enchantability grater than 0, and be a book, enchanted book, or an tool.
     *
     * @param itemStack The ItemStack to check.
     * @return boolean Whether or not the ItemStack is enchantable.
     */
    public static boolean isItemEnchantable (ItemStack itemStack) {

        return itemStack.getItem().getItemEnchantability(itemStack) > 0 && (itemStack.getItem() == Items.BOOK || itemStack.getItem() == Items.ENCHANTED_BOOK || itemStack.isItemEnchantable());
    }

    /**
     * Calculates how many experience points are it would take to get to the specified level.
     *
     * @param level The level to calculate for.
     * @return int The amount of experience points required to go from level 0 to the specified
     *         level.
     */
    public static int getExperienceFromLevel (int level) {

        return (int) (level < 16 ? 17 * level : level > 15 && level < 31 ? 1.5f * (level * level) - 29.5f * level + 360 : 3.5f * (level * level) - 151.5f * level + 2220);
    }

    /**
     * Calculate the amount of experience to go from one level to another.
     *
     * @param startingLevel The level you are currently at.
     * @param destinationLevel The level you want to go to.
     * @return int The amount of experience points needed to go from the startingLevel to the
     *         destinationLevel.
     */
    public static int getExperienceToLevel (int startingLevel, int destinationLevel) {

        return getExperienceFromLevel(destinationLevel) - getExperienceFromLevel(startingLevel);
    }

    /**
     * Calculates the amount of levels that an amount of EXP is equal to. This is a pretty
     * costly method due to the level curve.
     *
     * @param exp The amount of EXP to solve for.
     * @return int The amount of levels that can be created by the amount of exp.
     */
    public static int getLevelsFromExperience (int exp) {

        int currentLevel = 0;

        float levelCap = getExperienceToLevel(currentLevel, currentLevel + 1);

        int currentExp = exp;

        while (currentExp >= levelCap) {

            currentExp -= levelCap;
            currentLevel += 1;
            levelCap = getExperienceToLevel(currentLevel, currentLevel + 1);
        }

        return currentLevel;
    }

    /**
     * Checks if two enchantments are compatible with each other. For two enchantments to be
     * compatible, both of their canApplyTegether methods must return true.
     *
     * @param firstEnchantment The first Enchantment to check.
     * @param secondEnchantment The second Enchantment to check.
     * @return boolean Whether or not the two enchantments are compatible or not.
     */
    public static boolean areEnchantmentsCompatible (Enchantment firstEnchantment, Enchantment secondEnchantment) {

        return firstEnchantment.isCompatibleWith(secondEnchantment);
    }

    /**
     * Gets a display string for a given amount of EXP. If the amount of EXP is less than 1
     * level, it will be shown as XP, if it's enough to equal a level, it's shown as levels.
     *
     * @param xp The amount of exp to display.
     * @return A formatted string for display.
     */
    public static String getExpForDisplay (int xp) {

        final int levels = getLevelsFromExperience(xp);

        return levels > 0 ? levels + "L" : xp + "xp";
    }

    /**
     * Gets the enchantment power for a given position in a world. This uses the enchantment
     * table logic, so it searches for blocks that are two blocks out from the position passed.
     *
     * @param world The world to check in.
     * @param pos The position to get the enchanting power of.
     * @return The enchantment power for a given position in the world.
     */
    public static float getEnchantingPower (World world, BlockPos pos) {

        final int x = pos.getX();
        final int y = pos.getY();
        final int z = pos.getZ();

        float power = 0;

        for (int zOffset = -1; zOffset <= 1; zOffset++) {

            for (int xOffset = -1; xOffset <= 1; xOffset++) {

                if ((zOffset != 0 || xOffset != 0) && world.isAirBlock(new BlockPos(x + xOffset, y, z + zOffset)) && world.isAirBlock(new BlockPos(x + xOffset, y + 1, z + zOffset))) {

                    power += ForgeHooks.getEnchantPower(world, new BlockPos(x + xOffset * 2, y, z + zOffset * 2));
                    power += ForgeHooks.getEnchantPower(world, new BlockPos(x + xOffset * 2, y + 1, z + zOffset * 2));

                    if (xOffset != 0 && zOffset != 0) {

                        power += ForgeHooks.getEnchantPower(world, new BlockPos(x + xOffset * 2, y, z + zOffset));
                        power += ForgeHooks.getEnchantPower(world, new BlockPos(x + xOffset * 2, y + 1, z + zOffset));
                        power += ForgeHooks.getEnchantPower(world, new BlockPos(x + xOffset, y, z + zOffset * 2));
                        power += ForgeHooks.getEnchantPower(world, new BlockPos(x + xOffset, y + 1, z + zOffset * 2));
                    }
                }
            }
        }

        return power;
    }
}