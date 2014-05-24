package bspkrs.treecapitator;

import bspkrs.treecapitator.config.TCSettings;
import bspkrs.treecapitator.fml.gui.GuiConfigCustomCategoryListEntry;
import bspkrs.util.config.Configuration;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    public boolean serverDetected = false;
    
    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        new TCClientTicker();
    }
    
    @Override
    public boolean isEnabled()
    {
        return serverDetected && TCSettings.enabled;
    }
    
    @Override
    public void setServerDetected()
    {
        serverDetected = true;
    }
    
    @Override
    public void addGuiConfigCustomCategoryListEntry(Configuration config, String category)
    {
        config.setCategoryCustomIGuiConfigListEntryClass(category, GuiConfigCustomCategoryListEntry.class);
    }
}
