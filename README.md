# Solr Examples

This repo demonstrates several ways to use Solr.

Java utilizes Solrj to index, search, delete documents.
Python utilizes Pysolr to do the same.

## Commands
To launch a demo Solr docker, run
```docker run --rm -d --name solr-initial -p 8983:8983 solr solr-precreate initial_core```

These queries performed against a Solr Docker container with
a core called "initial_core".

A ```wiki_movie_plots_deduped.csv``` is indexed to provide
a bit more interesting content. This may be indexed via the Solr admin interface at ```localhost:8983```

The Java program may be run by importing this repo into IntelliJ and running Indexer.java

Python program may be run by creating a virtualenv, installing ```requirements.text``` and running
pysolrDemo.py

The Json to Solr indexer uses a reddit comment file from ```https://files.pushshift.io/reddit/comments/```. 
These files are in JSONL format, each line is a JSON object.
These can be quite large (100+gb) so we use Jackson Streaming.