package es.gorka.edu.components;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.gorka.edu.dto.AlumnoDTO;
import es.gorka.edu.service.LonganizaService;
import es.gorka.edu.service.NaranjaService;
import es.gorka.edu.service.TofuService;


public class ListDesayunoPage extends WebPage{
	
	@SpringBean
	LonganizaService longaniza;
	
	@SpringBean
	TofuService tofu;
	
	@SpringBean
	NaranjaService naranja;
	
	private static final Logger logger = LogManager.getLogger(ListAuthorPage.class.getName());
	
	private String current = null;

	private List listDesayuno = Collections.emptyList();
	
	private String precioUnidad = null;
	
	private int total = 0;
	private int precioTotal = 0;

	public ListDesayunoPage(PageParameters parameters) {
		current = parameters.get("current").toString();
		logger.debug("Cargando la pagina con el parametro " + current);
		initComponents();
	}

	public ListDesayunoPage() {
		initComponents();
	}

	private void initComponents() {
		add(new Label("title", "Listar"));
		addForm();
		addFeedBackPanel();
		addListAuthorView();
	}

	private void addForm() {
		Form form = new Form("form", new CompoundPropertyModel(new AlumnoDTO())) {};
		
		Button longaniza = new Button("longanizaList") {
			public void onSubmit() {
				PageParameters pageParameters = new PageParameters();
				pageParameters.add("current",  "Longaniza");
				setResponsePage(ListDesayunoPage.class, pageParameters);
			}
		};
		
		Button tofu = new Button("tofuLIst") {
			public void onSubmit() {
				PageParameters pageParameters = new PageParameters();
				pageParameters.add("current",  "Tofu");
				setResponsePage(ListDesayunoPage.class, pageParameters);
			}
		};
		
		Button naranja = new Button("naranjaList") {
			public void onSubmit() {
				PageParameters pageParameters = new PageParameters();
				pageParameters.add("current",  "Naranja");
				setResponsePage(ListDesayunoPage.class, pageParameters);
			}
		};
		
		Button total = new Button("totalizadoList") {
			public void onSubmit() {
				PageParameters pageParameters = new PageParameters();
				pageParameters.add("current",  "Total");
				setResponsePage(ListDesayunoPage.class, pageParameters);
			}
		};
		
		form.add(longaniza);
		form.add(tofu);
		form.add(naranja);
		form.add(total);

		add(form);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addListAuthorView() {
		if(current == "Longaniza"){
			listDesayuno = longaniza.listAll();
			precioUnidad = "2 euros";
			total = listDesayuno.size();
			precioTotal =  total * 2;
		}else if(current == "Tofu"){
			listDesayuno = tofu.listAll();
			precioUnidad = "2 euros";
			total = listDesayuno.size();
			precioTotal =  total * 2;
		}else if(current == "Naranja"){
			listDesayuno = naranja.listAll();
			precioUnidad = "1 euro";
			total = listDesayuno.size();
			precioTotal =  total * 1;
		}else if(current == "Total"){
			
		}
		
		ListView listview = new ListView("desayuno-group", listDesayuno) {

			@Override
			protected void populateItem(ListItem item) {
				AlumnoDTO author = (AlumnoDTO) item.getModelObject();
				item.add(new Label("alumno", author.getAlumno()));
				item.add(new Label("precio", precioUnidad));
			}
		};
		add(listview);
		add(new Label("total",  "Total estudiantes "+ total +", Dinero recaudado "+ precioTotal +" euros"));
		
	}

}