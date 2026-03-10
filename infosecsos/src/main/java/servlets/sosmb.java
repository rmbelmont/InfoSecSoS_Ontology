package servlets;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class sosmb {

	public List<String> retornarResposta() throws OWLOntologyCreationException {

		String fatoresespecificos = "FatoresEspecificos";

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		File file = new File("C:\\Users\\roberto\\Desktop\\Versoes-SegInfoSoS\\SegInfoSoS.owl");

		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		List<String> fatoresespecificosentrada = new ArrayList<String>();
		for (OWLClass c : ontology.getClassesInSignature()) {
			if (c.getIRI().getShortForm().equals(fatoresespecificos)) {

				NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
				// System.out.println("Class : " + c.getIRI().getShortForm());
				for (OWLNamedIndividual i : instances.getFlattened()) {
					// System.out.println(i.getIRI().getShortForm());

					fatoresespecificosentrada.add(i.getIRI().getShortForm());

				}
			}

		}
		return fatoresespecificosentrada;
	}

	public List<String> Carregar_Subclasse() throws OWLOntologyCreationException {

		File file = new File("C:\\Users\\roberto\\Desktop\\Mestrado_2022\\InfoSecSoS_3.owl");

		List<String> a = new ArrayList<String>();

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> tempList = new ArrayList<String>();

		for (OWLClass clss : ontology.getClassesInSignature()) {
			if (reasoner.getSubClasses(clss, false).getFlattened().size() > 1) {

				System.out.println("A classe " + clss.getIRI().getFragment() + " possui "
						+ reasoner.getSubClasses(clss, true).getFlattened().size() + " Sub-classe(s)");

				// System.out.println("\nAsserted superclasses of " +
				// clss.getIRI().getFragment());

				Set<OWLClass> SubClasse = reasoner.getSubClasses(clss, true).getFlattened();

				String seq = "";

				Iterator<OWLClass> i = SubClasse.iterator();
				while (i.hasNext()) {
					seq = i.next().toString();
					if (!seq.contains("Nothing"))
						tempList.add(seq.substring(seq.indexOf("#") + 1, seq.indexOf(">")));

				}

			}
		}

		return tempList;

	}

	public List<String> Carregar_Subclasse2() throws OWLOntologyCreationException {
		String Components_Information_Security = "Components_Information_Security";

		File file = new File("C:\\Users\\roberto\\Desktop\\Mestrado_2022\\InfoSecSoS_3.owl");

		List<String> a = new ArrayList<String>();

		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);

		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

		List<String> tempList = new ArrayList<String>();

		for (OWLClass clss : ontology.getClassesInSignature()) {
			if (reasoner.getSubClasses(clss, false).getFlattened().size() > 1
					&& clss.getIRI().getShortForm().equals(Components_Information_Security)) {

				System.out.println("A classe " + clss.getIRI().getFragment() + " possui "
						+ reasoner.getSubClasses(clss, true).getFlattened().size() + " Sub-classe(s)");

				// System.out.println("\nAsserted superclasses of " +
				// clss.getIRI().getFragment());

				Set<OWLClass> SubClasse = reasoner.getSubClasses(clss, true).getFlattened();

				String seq = "";

				Iterator<OWLClass> i = SubClasse.iterator();
				while (i.hasNext()) {
					seq = i.next().toString();
					if (!seq.contains("Nothing"))
						tempList.add(seq.substring(seq.indexOf("#") + 1, seq.indexOf(">")));

				}

			}
		}

		return tempList;

	}

	public List<String> FatoresEspecificos2() throws OWLOntologyCreationException {
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

		for (OWLClass clss : ontology.getClassesInSignature()) {
			if (reasoner.getSubClasses(clss, false).getFlattened().size() > 1
					&& clss.getIRI().getShortForm().equals(Components_Information_Security)) {

				System.out.println("A classe " + clss.getIRI().getFragment() + " possui "
						+ reasoner.getSubClasses(clss, true).getFlattened().size() + " Sub-classe(s)");

				// System.out.println("\nAsserted superclasses of " +
				// clss.getIRI().getFragment());

				Set<OWLClass> SubClasse = reasoner.getSubClasses(clss, true).getFlattened();

				String seq = "";

				Iterator<OWLClass> i = SubClasse.iterator();
				while (i.hasNext()) {
					seq = i.next().toString();
					if (!seq.contains("Nothing"))
						tempList.add(seq.substring(seq.indexOf("#") + 1, seq.indexOf(">")));

				}

			}
		}

		return tempList;

	}
}
