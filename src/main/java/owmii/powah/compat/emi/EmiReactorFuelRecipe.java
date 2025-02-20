package owmii.powah.compat.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;
import owmii.powah.Powah;
import owmii.powah.item.Itms;
import owmii.powah.recipe.ReactorFuel;

class EmiReactorFuelRecipe implements EmiRecipe {
    public static final ResourceLocation GUI_BACK = Powah.id("textures/gui/jei/misc.png");

    public static final PowahEmiCategory CATEGORY = new PowahEmiCategory(Powah.id("reactor_fuels"), EmiStack.of(Itms.URANINITE.get()),
            Component.translatable("gui.powah.jei.category.reactor.fuels"));

    private final ResourceLocation id;
    private final ReactorFuel recipe;

    private final EmiIngredient input;

    public EmiReactorFuelRecipe(ResourceLocation id, ReactorFuel fuel) {
        this.id = id;
        this.recipe = fuel;
        var stack = BuiltInRegistries.ITEM.get(id).getDefaultInstance();
        this.input = EmiIngredient.of(Ingredient.of(stack));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return CATEGORY;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(input);
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of();
    }

    @Override
    public int getDisplayWidth() {
        return 158;
    }

    @Override
    public int getDisplayHeight() {
        return 26;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(GUI_BACK, 0, 1, 160, 24, 0, 0);
        widgets.addSlot(input, 3, 4).drawBack(false);

        widgets.addText(
                Component.translatable("info.lollipop.amount").append(": ").append(Component.translatable("info.lollipop.mb", recipe.fuelAmount())),
                30,
                3, 0x444444, false);
        var coloredTemperature = Component.literal(String.valueOf(recipe.temperature())).withStyle(ChatFormatting.DARK_RED);
        widgets.addText(Component.translatable("info.lollipop.temperature").append(": ")
                .append(Component.translatable("info.lollipop.temperature.c", coloredTemperature)), 30, 15, 0x444444, false);

    }
}
