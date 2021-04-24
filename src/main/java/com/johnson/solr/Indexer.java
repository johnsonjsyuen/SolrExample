package com.johnson.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.List;

public class Indexer{

    public static void main(String[]args) throws IOException, SolrServerException {

        var solrClient = new SolrFactory().getSolr();

        //Generate and index some documents
        for(int i=1000;i<2000;++i) {
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("cat", "book");
            doc.addField("id", "book-" + i);
            doc.addField("name", "The Legend of the Hobbit part " + i);
            solrClient.add(doc);
            if(i%100==0) solrClient.commit();  // periodically flush
        }
        solrClient.commit();

        //delete by query
        solrClient.deleteByQuery("name:Legend of");
        solrClient.commit();


        //Query
        final SolrQuery query = new SolrQuery("Plot:dog");
        query.addFilterQuery("Genre:comedy");
        query.addFacetField("Genre");
        var resp = solrClient.query(query);

        var results = resp.getResults();
        var facets = resp.getFacetFields();

        for(var doc:results){
            System.out.println(doc.toString());
            System.out.println();
        }
        System.out.println(facets);

        //Java bean indexing
        final Movie johnsonMovie = Movie.builder()
                .Director(List.of("Johnson"))
                .Genre(List.of("Comedy"))
                .id(List.of("asdlfjalfnewkanfwalfnwa"))
                .Origin_Ethnicity(List.of("Australia"))
                .Plot(List.of("Something happens more things happen the end"))
                .Release_Year(List.of(2021))
                .Title(List.of("The Johnson Movie"))
                .Wiki_Page(List.of("http://en.wikipedia.com"))
                .build();
        var response = solrClient.addBean(johnsonMovie);

        solrClient.commit();

        //Java Bean query
        final SolrQuery beanQuery = new SolrQuery("Plot:*johnson*\n" +
                "Title:*johnson*\n" +
                "Release_Year:2021\n" +
                "Director:Johnson");
        beanQuery.addFilterQuery("Plot:*");

        final var beanResponse = solrClient.query(beanQuery);
        final var movies = beanResponse.getBeans(Movie.class);
        System.out.println(movies.get(0));
    }
}
