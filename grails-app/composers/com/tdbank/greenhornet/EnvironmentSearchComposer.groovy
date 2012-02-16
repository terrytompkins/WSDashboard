package com.tdbank.greenhornet

import java.util.List;

import org.zkoss.zk.ui.Component
import org.zkoss.zkplus.databind.BindingListModelList
import org.zkoss.zk.ui.event.Event
import org.zkoss.zul.*

class EnvironmentSearchComposer {
	def envSearchWindow
	def envSearchGrid
	def jvmFilter
	def regionFilter
	def channelFilter
	def projectFilter
	def codePhaseFilter
	def environmentService

    def afterCompose = {Component comp ->
		envSearchGrid.setRowRenderer(new EnvironmentRowRenderer());
		envSearchGrid.setModel(new ListModelList(FoodData.getAllFoods()));
    }

	// Pillage from getFoodByInput method below
	void getEnvDataByInput(Event event) {
		// ((Textbox) event.getTarget()).setValue(((org.zkoss.zk.ui.event.InputEvent) event).getValue());
		// envSearchGrid.setModel(new ListModelList(FoodData.getFilterFoods(filter1.getValue(), filter2.getValue(), filter3.getValue())));
		// @@@ filter columns independently select rows by value of filter select field.  from this construct List-based dataset
		// @@@ Store filtered data in an array of groovy Map objects @@@
	}
	
	public List<Jvm> getEnvDataForJvms()
	{
		List<Jvm> jvms = Jvm.list() as List

 		return new BindingListModelList(jvms, false)		
	}
	
   /*	
   //Filter Function
   void getFoodByInput(Event event) {
	   ((Textbox) event.getTarget()).setValue(((org.zkoss.zk.ui.event.InputEvent) event).getValue());
	   demoGrid.setModel(new ListModelList(FoodData.getFilterFoods(filter1.getValue(), filter2.getValue(), filter3.getValue())));
	   if (demoGrid.getRows().getChildren().size() > 0) {
		   footer_msg.setLabel("");
		   footer_category.setLabel("A Total of " + demoGrid.getRows().getChildren().size() + " Food Items");
	   } else { // Handle empty message
		   footer_msg.setLabel("Nothing found ...");
		   footer_category.setLabel("");
	   }
   }
   
 
   
   public List<AttributeComponent> getAttributeComponentsForFacet(facet, formMode)
   {
	   // @@@ once everything is working, remove the logging information below.
	   AttributeComponent.list().each { ac ->
		   System.out.println("attribute name= " + ac.taskAttribute.name)
	   }
	   List<AttributeComponent> attributeComponentsForFacet = AttributeComponent.findAllByFacetAndFormMode(facet, formMode) as List
	   
		return new BindingListModelList(attributeComponentsForFacet, false)
   }
   */
}


public class EnvironmentRowRenderer implements RowRenderer {
	@Override
	public void render(Row row, Object data) throws Exception {
		/*
		   Food f = (Food) data;
		   new Label(f.getCategory()).setParent(row);
		   new Label(f.getName()).setParent(row);
		   new Label(f.getTopNutrients()).setParent(row);
		   new Label(f.getDailyPercent() + "").setParent(row);
		   new Label(f.getCalories() + "").setParent(row);
		   new Label(f.getQuantity()).setParent(row);
		 */
	}
}