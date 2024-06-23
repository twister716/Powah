package owmii.powah.lib.client.wiki.page;

import java.util.function.Consumer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;
import owmii.powah.lib.client.screen.Texture;
import owmii.powah.lib.client.wiki.Entry;
import owmii.powah.lib.client.wiki.Icon;
import owmii.powah.lib.client.wiki.Page;
import owmii.powah.lib.client.wiki.Section;

public class CatPage extends Page {
    public CatPage(String name, Section parent) {
        super(name, parent);
    }

    public CatPage e(ItemLike provider, Consumer<Entry> consumer) {
        return e("", provider, consumer);
    }

    public CatPage e(String name, ItemLike icon, Consumer<Entry> consumer) {
        return e(name, new Icon(icon), consumer);
    }

    public CatPage e(String name, Texture icon, Consumer<Entry> consumer) {
        return e(name, new Icon(icon), consumer);
    }

    public CatPage e(String name, Consumer<Entry> consumer) {
        return e(name, (Icon) null, consumer);
    }

    public CatPage e(String name, @Nullable Icon icon, Consumer<Entry> consumer) {
        Entry entry = new Entry(name, icon, getWiki());
        consumer.accept(entry);
        getWiki().register(entry);
        return this;
    }
}
