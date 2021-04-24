package com.johnson.solr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
@Field private List<String> Title;
@Field private List<String> Director;
@Field private List<String> Genre;
@Field private List<String> Plot;
@Field private List<String> id;
@Field private List<Integer> Release_Year;
@Field private List<String> Origin_Ethnicity;
@Field private List<String> Wiki_Page;
}
