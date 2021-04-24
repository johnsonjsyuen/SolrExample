package com.johnson.solr;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrFactory {
    private final SolrClient client;

    public SolrFactory(){
        this.client = new HttpSolrClient.Builder("http://localhost:8983/solr/jcg_example_core/").build();
    }

    public SolrClient getSolr(){
        return this.client;
    }
}
