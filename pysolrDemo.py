import pysolr

# Create a client instance. The timeout and authentication options are not required.
solr = pysolr.Solr('http://localhost:8983/solr/initial_core', always_commit=True)

# Note that auto_commit defaults to False for performance. You can set
# `auto_commit=True` to have commands always update the index immediately, make
# an update call with `commit=True`, or use Solr's `autoCommit` / `commitWithin`
# to have your data be committed following a particular policy.

# Do a health check.
solr.ping()

new_film = {
    "Title": "Johnson film",
    "Director": "R2D2",
    "Genre": "Sci fi",
    "Plot": "Things happen, then other things happen",
    "Release_Year": 2021,
    "Origin_Ethnicity": "Australian",
    "Wiki_Page": "https://en.wikipedia.org/wiki/johnson_film",
}

solr.add(new_film)
# Manual commit if autocommit is set to false (to enable batching)
solr.commit()

results = solr.search('Title:johnson', **{
    'fq': '*',
})

# The ``Results`` object stores total results found, by default the top
# ten most relevant results and any additional data like
# facets/highlighting/spelling/etc.
print(f"Saw {len(results)} result(s).")

# Just loop over it to access the results.
for result in results:
    print(f"The title is '{result['Title']}'.")

# Delete by query
solr.delete(q='Title:Johnson film')