package servlets;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

public class Principal {
	
	
	

	public List<String> FatoresEspecificos() throws OWLOntologyCreationException {
		String Components_Information_Security = "Components_Information_Security";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		
		
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);
		
		

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> tempList = new ArrayList<String>();
		String tempList2 = null;

		for (OWLClass clss : ontology.getClassesInSignature()) {
			if (reasoner.getSubClasses(clss, false).getFlattened().size() > 1
					&& clss.getIRI().getShortForm().equals(Components_Information_Security)) {

				System.out.println("A classe " + clss.getIRI().getFragment() + " possui "
						+ reasoner.getSubClasses(clss, true).getFlattened().size() + " Sub-classe(s)");

				 System.out.println("\nAsserted superclasses of " +
				 clss.getIRI().getFragment());

				Set<OWLClass> SubClasse = reasoner.getSubClasses(clss, true).getFlattened();

				String seq = "";

				Iterator<OWLClass> i = SubClasse.iterator();
				while (i.hasNext()) {
					seq = i.next().toString();
					if (!seq.contains("Nothing"))
						tempList.add(seq.substring(seq.indexOf("#") + 1, seq.indexOf(">")));
					Collections.sort(tempList);

				}

			}

		}
		return tempList;

	}

	public Integer Classes() throws OWLOntologyCreationException {
		String Components_Information_Security = "Components_Information_Security";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		Integer tempNumero = 0;

		for (OWLClass clss : ontology.getClassesInSignature()) {
			if (reasoner.getSubClasses(clss, false).getFlattened().size() > 1
					&& clss.getIRI().getShortForm().equals(Components_Information_Security)) {

				tempNumero = reasoner.getSubClasses(clss, true).getFlattened().size();

			}

		}
		return tempNumero;

	}

	public List<String> Tecnicas() throws OWLOntologyCreationException {

		String Components_Information_Security = "Components_Information_Security";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Components_Information_Security)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		return lista;

	}

	public Integer TecnicasInteger() throws OWLOntologyCreationException {

		String Components_Information_Security = "Components_Information_Security";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Components_Information_Security)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}

	public List<String> TecnologiasFatoresEspecificos() throws OWLOntologyCreationException {

		String Specific_Factor = "Specific_Factor";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Specific_Factor)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		return lista;

	}

	public Integer TecnologiasFatoresEspecificoInteger() throws OWLOntologyCreationException {

		String Specific_Factor = "Specific_Factor";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Specific_Factor)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}

	public List<String> FatoresHumanos() throws OWLOntologyCreationException {

		String Human_Factor = "Human_Factor";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Human_Factor)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		return lista;

	}

	public Integer FatoresHumanosInteger() throws OWLOntologyCreationException {

		String Human_Factor = "Human_Factor";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Human_Factor)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}

	public List<String> Avaliacao() throws OWLOntologyCreationException {

		String Assessment_Methodology = "Assessment_Methodology";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Assessment_Methodology)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		return lista;

	}

	public Integer AvaliacaoInteger() throws OWLOntologyCreationException {

		String Assessment_Methodology = "Assessment_Methodology";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Assessment_Methodology)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}

	public List<String> Criptografia() throws OWLOntologyCreationException {

		String Cryptography = "Cryptography";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Cryptography)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		System.out.println(lista);
		return lista;

	}

	public Integer CriptografiaInteger() throws OWLOntologyCreationException {

		String Cryptography = "Cryptography";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Cryptography)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}

	public List<String> Algoritmo() throws OWLOntologyCreationException {

		String Algorithm = "Algorithm";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Algorithm)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		return lista;

	}

	public Integer AlgoritmoInteger() throws OWLOntologyCreationException {

		String Algorithm = "Algorithm";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Algorithm)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}

	public Integer Application_DomainInteger() throws OWLOntologyCreationException {

		String Application_Domain = "Application_Domain";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Application_Domain)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}
	
	public Integer Threat_Type_Integer() throws OWLOntologyCreationException {

		String Threat_Type = "Threat_Type";
		Integer numeroInteger = null;

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Threat_Type)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);

				numeroInteger = instances.entities().toArray().length;
			}
		}
		return numeroInteger;

	}

	public static List<String> buscarCriptografiaPorNome(List<String> lista, String Cryptography) {

		String nulo = "Was not found!";
		List<String> resultadoNulo = new ArrayList<>();
		resultadoNulo.add(nulo);
		Pattern p = Pattern.compile(Cryptography, Pattern.CASE_INSENSITIVE);
		List<String> resultado = new ArrayList<>();

		for (String string : lista) {
			if (p.matcher(string).find() && string != null) {
				resultado.add(string);

				return resultado;
			}
		}
		return resultadoNulo;
	}

	public static List<String> buscarAlgoritmoPorNome(List<String> lista, String Algorithm) {

		String nulo = "Was not found!";
		List<String> resultadoNulo = new ArrayList<>();
		resultadoNulo.add(nulo);
		Pattern p = Pattern.compile(Algorithm, Pattern.CASE_INSENSITIVE);
		List<String> resultado = new ArrayList<>();

		for (String string : lista) {
			if (p.matcher(string).find() && string != null) {
				resultado.add(string);

				return resultado;
			}
		}
		return resultadoNulo;
	}

	public static boolean isNumeric(String str) {

		if (str == null || str.length() == 0) {
			return false;
		}

		try {
			Double.parseDouble(str);
			return true;

		} catch (NumberFormatException e) {
			return false;
		}

	}
	 public static boolean isNumeric1(String str) {
	        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	    }
	 public static boolean isNumeric2(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	 public static boolean isNumeric3(String str) {
		 
	        if (str == null || str.length() == 0) {
	            return false;
	        }
	 
	        try {
	            Double.parseDouble(str);
	            return true;
	 
	        } catch (NumberFormatException e) {
	            return false;
	        }
	 
	    }

	public static List<String> buscarAlgoritmoPorNome2(List<String> lista, String Algorithm) {

		String nulo = "Text Invalid!";
		String naoEncontrado = "Was not found!";
		List<String> resultadoNulo = new ArrayList<>();
		resultadoNulo.add(nulo);
		Pattern p = Pattern.compile(Algorithm, Pattern.CASE_INSENSITIVE);
		List<String> resultado = new ArrayList<>();
		List<String> resultado1 = new ArrayList<>();
		resultado1.add(naoEncontrado);
		
		

		for (String string : lista) {
			if (p.matcher(string).find() && string != null) {
				resultado.add(string);

				return resultado;
			}
		}
		for (String string1 : lista) {
			if (isNumeric2(string1) == true) {
			
					return resultadoNulo;

				}
		}
		
		
		

		return resultado1;
	}

	public static List<String> buscarAlgoritmoPorNome3(List<String> lista, String Algorithm) {

		String nulo = "Texto Inválido!";
		List<String> resultadoNulo = new ArrayList<>();
		resultadoNulo.add(nulo);
		List<String> resultado1 = new ArrayList<>();
		Pattern p = Pattern.compile(Algorithm);
		List<String> resultado = new ArrayList<>();

		for (String string : lista) {
			if (p.matcher(string).find() && string != null) {
				resultado.add(string);

				return resultado;
			}
		}
		return resultadoNulo;
	}

	public List<String> transformarInstancia(List<String> resultado) {
		List<String> instancia = new ArrayList<String>();

		for (int i = 0; i < resultado.size(); i++) {
			String cor = resultado.get(i);
			cor = cor.replace("_", " ");

			instancia.add(cor);

		}

		return instancia;
	}

	public List<String> Application_Domain() throws OWLOntologyCreationException {

		String Application_Domain = "Application_Domain";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Application_Domain)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		return lista;

	}
	public List<String> Threat_Type() throws OWLOntologyCreationException {

		String Threat_Type = "Threat_Type";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		ClassLoader classLoader = this.getClass().getClassLoader();
		String fileName = "InfoSecSoS_3.owl";
		File configFile = new File(classLoader.getResource(fileName).getFile());
		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(configFile);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> lista = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(Threat_Type)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				 System.out.println("Pegar a quantidade de classes : " +
				 c.getIRI().length()+"\n");
				System.out.println("\nQtde de Tecnologias : " + instances.entities().toArray().length + "\n");
				Object[] Instancias = instances.entities().toArray();

				for (int i = 0; i < Instancias.length; i++) {
					 System.out.println("posicao " + (i+1) + " = " +Instancias[i] );
				}

				for (OWLNamedIndividual i : instances.getFlattened()) {

					lista.add(i.getIRI().getShortForm());
					Collections.sort(lista);

				}

			}

		}
		return lista;

	}


}
