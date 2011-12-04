package org.rhok.txt4g.execution;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.VCARD;

public class SemanticNewsJob {
	static String personURI    = "http://somewhere/JohnSmith";
	static String fullName     = "John Smith";

	public SemanticNewsJob() {
		// some definitions

		// create an empty Model
		Model model = ModelFactory.createDefaultModel();

		// create the resource
		Resource johnSmith = model.createResource(personURI);

		// add the property
		 johnSmith.addProperty(VCARD.FN, fullName);
	}
}
