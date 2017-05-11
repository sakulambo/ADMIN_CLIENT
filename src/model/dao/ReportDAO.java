/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import java.awt.Color;
import java.util.Collection;
import model.pojo.Drinks;
import model.pojo.Foods;
import model.pojo.Menus;
import model.pojo.Tables;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author sakulambo
 */
public class ReportDAO {

    private Collection<Drinks> drinkList;
    private Collection<Foods> foodList;
    private Collection<Tables> tableList;
    private Collection<Menus> menusList;

    public Collection<Drinks> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(Collection<Drinks> drinkList) {
        this.drinkList = drinkList;
    }

    public Collection<Foods> getFoodList() {
        return foodList;
    }

    public void setFoodList(Collection<Foods> foodList) {
        this.foodList = foodList;
    }

    public Collection<Tables> getTableList() {
        return tableList;
    }

    public void setTableList(Collection<Tables> tableList) {
        this.tableList = tableList;
    }

    public Collection<Menus> getMenusList() {
        return menusList;
    }

    public void setMenusList(Collection<Menus> menusList) {
        this.menusList = menusList;
    }
    
    
    public JasperPrint getReport() throws ColumnBuilderException, JRException, ClassNotFoundException {
        Style headerStyle = createHeaderStyle();
        Style detailTextStyle = createDetailTextStyle();
        Style detailNumberStyle = createDetailNumberStyle();
        DynamicReport dynaReport = getReportTable(headerStyle, detailTextStyle, detailNumberStyle);
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dynaReport, new ClassicLayoutManager(), new JRBeanCollectionDataSource(tableList));
        return jp;
    }

    public JasperPrint getReportTable() throws ColumnBuilderException, JRException, ClassNotFoundException {
        Style headerStyle = createHeaderStyle();
        Style detailTextStyle = createDetailTextStyle();
        Style detailNumberStyle = createDetailNumberStyle();
        DynamicReport dynaReport = getReportTable(headerStyle, detailTextStyle, detailNumberStyle);
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dynaReport, new ClassicLayoutManager(), new JRBeanCollectionDataSource(tableList));
        return jp;
    }
    
      public JasperPrint getReportMenus() throws ColumnBuilderException, JRException, ClassNotFoundException {
        Style headerStyle = createHeaderStyle();
        Style detailTextStyle = createDetailTextStyle();
        Style detailNumberStyle = createDetailNumberStyle();
        DynamicReport dynaReport = getReportMenu(headerStyle, detailTextStyle, detailNumberStyle);
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dynaReport, new ClassicLayoutManager(), new JRBeanCollectionDataSource(menusList));
        return jp;
    }
      
      public JasperPrint getReportDrinks() throws ColumnBuilderException, JRException, ClassNotFoundException {
        Style headerStyle = createHeaderStyle();
        Style detailTextStyle = createDetailTextStyle();
        Style detailNumberStyle = createDetailNumberStyle();
        DynamicReport dynaReport = getReportDrink(headerStyle, detailTextStyle, detailNumberStyle);
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dynaReport, new ClassicLayoutManager(), new JRBeanCollectionDataSource(drinkList));
        return jp;
    }
      
      public JasperPrint getReportFoods() throws ColumnBuilderException, JRException, ClassNotFoundException {
        Style headerStyle = createHeaderStyle();
        Style detailTextStyle = createDetailTextStyle();
        Style detailNumberStyle = createDetailNumberStyle();
        DynamicReport dynaReport = getReportFood(headerStyle, detailTextStyle, detailNumberStyle);
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dynaReport, new ClassicLayoutManager(), new JRBeanCollectionDataSource(foodList));
        return jp;
    }
      
      

    private Style createHeaderStyle() {
        StyleBuilder sb = new StyleBuilder(true);
        sb.setFont(Font.VERDANA_MEDIUM_BOLD);
        sb.setBorder(Border.THIN());
        sb.setBorderBottom(Border.PEN_2_POINT());
        sb.setBorderColor(Color.BLACK);
        sb.setBackgroundColor(Color.ORANGE);
        sb.setTextColor(Color.BLACK);
        sb.setHorizontalAlign(HorizontalAlign.CENTER);
        sb.setVerticalAlign(VerticalAlign.MIDDLE);
        sb.setTransparency(Transparency.OPAQUE);
        return sb.build();
    }

    private Style createDetailTextStyle() {
        StyleBuilder sb = new StyleBuilder(true);
        sb.setFont(Font.VERDANA_MEDIUM);
        sb.setBorder(Border.DOTTED());
        sb.setBorderColor(Color.BLACK);
        sb.setTextColor(Color.BLACK);
        sb.setHorizontalAlign(HorizontalAlign.LEFT);
        sb.setVerticalAlign(VerticalAlign.MIDDLE);
        sb.setPaddingLeft(5);
        return sb.build();
    }

    private Style createDetailNumberStyle() {
        StyleBuilder sb = new StyleBuilder(true);
        sb.setFont(Font.VERDANA_MEDIUM);
        sb.setBorder(Border.DOTTED());
        sb.setBorderColor(Color.BLACK);
        sb.setTextColor(Color.BLACK);
        sb.setHorizontalAlign(HorizontalAlign.RIGHT);
        sb.setVerticalAlign(VerticalAlign.MIDDLE);
        sb.setPaddingRight(5);
        return sb.build();
    }

    private AbstractColumn createColumn(String property, Class type,
            String title, int width, Style headerStyle, Style detailStyle)
            throws ColumnBuilderException {
        AbstractColumn columnState = ColumnBuilder.getNew()
                .setColumnProperty(property, type.getName()).setTitle(
                title).setWidth(Integer.valueOf(width))
                .setStyle(detailStyle).setHeaderStyle(headerStyle).build();
        return columnState;
    }

    private DynamicReport getReport(Style headerStyle, Style detailTextStyle, Style detailNumStyle) throws ColumnBuilderException, ClassNotFoundException {

        DynamicReportBuilder report = new DynamicReportBuilder();

        AbstractColumn columnEmpNo = createColumn("empNo", Integer.class, "Employee Number", 30, headerStyle, detailTextStyle);
        AbstractColumn columnName = createColumn("name", String.class, "Name", 30, headerStyle, detailTextStyle);
        AbstractColumn columnSalary = createColumn("salary", Integer.class, "Salary", 30, headerStyle, detailNumStyle);
        AbstractColumn columnCommission = createColumn("commission", Float.class, "Commission", 30, headerStyle, detailNumStyle);
        report.addColumn(columnEmpNo)
                .addColumn(columnName).addColumn(columnSalary).addColumn(columnCommission);

        StyleBuilder titleStyle = new StyleBuilder(true);
        titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        titleStyle.setFont(new Font(20, Font._FONT_GEORGIA, true));

        StyleBuilder subTitleStyle = new StyleBuilder(true);
        subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        subTitleStyle.setFont(new Font(Font.MEDIUM, Font._FONT_GEORGIA, true));

        report.setTitle("Employee Report");
        report.setTitleStyle(titleStyle.build());
        report.setSubtitle("Commission received by Employee");
        report.setSubtitleStyle(subTitleStyle.build());
        report.setUseFullPageWidth(true);
        return report.build();
    }

    private DynamicReport getReportTable(Style headerStyle, Style detailTextStyle, Style detailNumStyle) {
        DynamicReportBuilder report = new DynamicReportBuilder();

        AbstractColumn columnTableId = createColumn("id", Integer.class, "Id", 30, headerStyle, detailTextStyle);
        AbstractColumn columnMaxPeople = createColumn("maxPeople", Integer.class, "Cantidad Maxima Gente", 30, headerStyle, detailTextStyle);
        //AbstractColumn columnEmpty = createColumn("empty", Boolean.class, "Vacio", 30, headerStyle, detailNumStyle);        
        report.addColumn(columnTableId)
                .addColumn(columnMaxPeople);//.addColumn(columnEmpty);

        StyleBuilder titleStyle = new StyleBuilder(true);
        titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        titleStyle.setFont(new Font(20, Font._FONT_GEORGIA, true));

        StyleBuilder subTitleStyle = new StyleBuilder(true);
        subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        subTitleStyle.setFont(new Font(Font.MEDIUM, Font._FONT_GEORGIA, true));

        report.setTitle("REPORTE DE MESAS");
        report.setTitleStyle(titleStyle.build());
        report.setSubtitle("Reporte donde se muestran todas las mesas i sus características");
        report.setSubtitleStyle(subTitleStyle.build());
        report.setUseFullPageWidth(true);
        return report.build();
    }
    
     private DynamicReport getReportMenu(Style headerStyle, Style detailTextStyle, Style detailNumStyle) {
        DynamicReportBuilder report = new DynamicReportBuilder();

        AbstractColumn columnMenuId = createColumn("id", Integer.class, "Id", 30, headerStyle, detailTextStyle);
        AbstractColumn columnMenuPeople = createColumn("peopleNumber", Short.class, "Maximo Personas", 30, headerStyle, detailTextStyle);              
        report.addColumn(columnMenuId) 
                .addColumn(columnMenuPeople);

        StyleBuilder titleStyle = new StyleBuilder(true);
        titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        titleStyle.setFont(new Font(20, Font._FONT_GEORGIA, true));

        StyleBuilder subTitleStyle = new StyleBuilder(true);
        subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        subTitleStyle.setFont(new Font(Font.MEDIUM, Font._FONT_GEORGIA, true));

        report.setTitle("REPORTE DE MENUS");
        report.setTitleStyle(titleStyle.build());
        report.setSubtitle("Reporte que muestra todos los menus por ID i la cantidad de gente máxima.");
        report.setSubtitleStyle(subTitleStyle.build());
        report.setUseFullPageWidth(true);
        return report.build();
    }
     
     private DynamicReport getReportFood(Style headerStyle, Style detailTextStyle, Style detailNumStyle) {
        DynamicReportBuilder report = new DynamicReportBuilder();

         AbstractColumn columnId = createColumn("id", Integer.class, "Id", 30, headerStyle, detailTextStyle);
        AbstractColumn columnName = createColumn("name", String.class, "Nombre", 30, headerStyle, detailTextStyle);              
        AbstractColumn columnPrice = createColumn("price", Double.class, "Precio(€)", 30, headerStyle, detailTextStyle);              
        AbstractColumn columnDescription = createColumn("description", String.class, "Descripción", 30, headerStyle, detailTextStyle);              
        AbstractColumn columnFamilyDish = createColumn("familyDish", String.class, "Tipo de plato", 30, headerStyle, detailTextStyle);              
        report.addColumn(columnId).addColumn(columnName).addColumn(columnPrice)
                .addColumn(columnDescription).addColumn(columnFamilyDish);

        StyleBuilder titleStyle = new StyleBuilder(true);
        titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        titleStyle.setFont(new Font(20, Font._FONT_GEORGIA, true));

        StyleBuilder subTitleStyle = new StyleBuilder(true);
        subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        subTitleStyle.setFont(new Font(Font.MEDIUM, Font._FONT_GEORGIA, true));

        report.setTitle("REPORTE DE COMIDAS");
        report.setTitleStyle(titleStyle.build());
        report.setSubtitle("Reporte que muestra las comidas con sus características.");
        report.setSubtitleStyle(subTitleStyle.build());
        report.setUseFullPageWidth(true);
        return report.build();
    }
         
    private DynamicReport getReportDrink(Style headerStyle, Style detailTextStyle, Style detailNumStyle) {
        DynamicReportBuilder report = new DynamicReportBuilder();

        AbstractColumn columnId = createColumn("id", Integer.class, "Id", 30, headerStyle, detailTextStyle);
        AbstractColumn columnName = createColumn("name", String.class, "Nombre", 30, headerStyle, detailTextStyle);              
        AbstractColumn columnPrice = createColumn("price", Double.class, "Precio(€)", 30, headerStyle, detailTextStyle);              
        AbstractColumn columnDescription = createColumn("description", String.class, "Descripción", 50, headerStyle, detailTextStyle);              
        AbstractColumn columnCapacity = createColumn("capacity", Integer.class, "Capacidad", 30, headerStyle, detailTextStyle);              
        AbstractColumn columnTypeBottle = createColumn("typeBottle", String.class, "Tipo de envase", 30, headerStyle, detailTextStyle);  
        AbstractColumn columnSoda = createColumn("soda", Boolean.class, "Azucarada", 30, headerStyle, detailTextStyle);              
        AbstractColumn columnAlcohol = createColumn("alcohol", Boolean.class, "Alcoholica", 30, headerStyle, detailTextStyle);              
        report.addColumn(columnId).addColumn(columnName).addColumn(columnPrice)
                .addColumn(columnDescription).addColumn(columnCapacity)
                .addColumn(columnTypeBottle).addColumn(columnSoda)
                .addColumn(columnAlcohol);

        StyleBuilder titleStyle = new StyleBuilder(true);
        titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        titleStyle.setFont(new Font(20, Font._FONT_GEORGIA, true));

        StyleBuilder subTitleStyle = new StyleBuilder(true);
        subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        subTitleStyle.setFont(new Font(Font.MEDIUM, Font._FONT_GEORGIA, true));

        report.setTitle("REPORTE DE BEBIDAS");
        report.setTitleStyle(titleStyle.build());
        report.setSubtitle("Reporte que muestra las bebidas con sus características.");
        report.setSubtitleStyle(subTitleStyle.build());
        report.setUseFullPageWidth(true);
        return report.build();
    }
}
