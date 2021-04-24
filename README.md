# SolrJ example queries

These queries performed against a Solr Docker container with
a core called "jcg_example_core".

A ```wiki_movie_plots_deduped.csv``` is indexed to provide
a bit more interesting content.

The Json to Solr indexer uses a comment file from ```https://files.pushshift.io/reddit/comments/```. 
These can be quite large (100+gb) so we use Jackson Streaming.