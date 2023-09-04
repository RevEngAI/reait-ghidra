/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ai.reveng.toolkit.ghidra.core;

import java.awt.BorderLayout;

import javax.swing.*;

import ai.reveng.toolkit.ghidra.ReaiPluginPackage;
import ai.reveng.toolkit.ghidra.core.services.api.ApiService;
import ai.reveng.toolkit.ghidra.core.services.configuration.ConfigurationService;
import ai.reveng.toolkit.ghidra.core.ui.wizard.SetupWizardManager;
import ai.reveng.toolkit.ghidra.core.ui.wizard.SetupWizardStateKey;
import docking.ActionContext;
import docking.ComponentProvider;
import docking.action.DockingAction;
import docking.action.ToolBarData;
import docking.wizard.WizardManager;
import docking.wizard.WizardState;
import ghidra.app.ExamplesPluginPackage;
import ghidra.app.plugin.PluginCategoryNames;
import ghidra.app.plugin.ProgramPlugin;
import ghidra.framework.plugintool.*;
import ghidra.framework.plugintool.util.PluginStatus;
import ghidra.util.HelpLocation;
import ghidra.util.Msg;
import resources.Icons;

/**
 * TODO: Provide class-level documentation that describes what this plugin does.
 */
//@formatter:off
@PluginInfo(
	status = PluginStatus.STABLE,
	packageName = ReaiPluginPackage.NAME,
	category = PluginCategoryNames.MISC,
	shortDescription = "Toolkit for using RevEngAI API",
	description = "Toolkit for using RevEng.AI API",
	servicesProvided = { ApiService.class, ConfigurationService.class }
)
//@formatter:on
public class CorePlugin extends ProgramPlugin {
	private static final String REAI_WIZARD_RUN_PREF = "REAISetupWizardRun";

	/**
	 * Plugin constructor.
	 * 
	 * @param tool The plugin tool that this plugin is added to.
	 */
	public CorePlugin(PluginTool tool) {
		super(tool);
		
		// check if we have already run the first time setup
		if (!hasSetupWizardRun()) {
			runSetupWizard();
//			setWizardRun();
		}

	}

	@Override
	public void init() {
		super.init();

		// TODO: Acquire services if necessary
	}
	
	private boolean hasSetupWizardRun() {
		String value = tool.getOptions("Preferences").getString(REAI_WIZARD_RUN_PREF, "false");
		return Boolean.parseBoolean(value);
	}
	
	private void setWizardRun() {
		tool.getOptions("Preferences").setString(REAI_WIZARD_RUN_PREF, "true");
	}
	
	private void runSetupWizard() {
		System.out.println("Running first time setup");
		SetupWizardManager setupManager = new SetupWizardManager(new WizardState<SetupWizardStateKey>(), getTool());
		WizardManager wizardManager = new WizardManager("RevEng.ai Setup Wizard", true, setupManager);
		wizardManager.showWizard(tool.getToolFrame());
		return;
	}

}
