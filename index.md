---
layout: default
title: Notes
---
<!-- This loops through the paginated posts -->
<ul class="listing">
{% for post in paginator.posts %}
  <li class="listing-item">
  <time datetime="{{ post.date | date:"%Y-%m-%d" }}">{{ post.date | date:"%Y-%m-%d" }}</time>&nbsp;&nbsp;
  <a href="{{ site.url }}{{ post.url }}" title="{{ post.title }}">{{ post.title }}</a>
  </li>
{% endfor %}
</ul>
<!-- Pagination links -->
<div class="pagination">
    <div id="post-pagination" class="pagination">
        {% if paginator.previous_page %}
        <span class="previous">
        {% if paginator.previous_page == 1 %}
        <a href="/">Previous</a>
        {% else %}
        <a href="{{ site.url }}/{{ paginator.previous_page_path }}">Previous</a>
        {% endif %}
        </span>
        {% else %}
        <span class="previous disabled">Previous</span>
        {% endif %}
        
        
        {% if paginator.page == 1 %}
        <span class="current-page">1</span>
        {% else %}
        <a href="{{ site.url }}">1</a>
        {% endif %}
            
        {% for count in (2..paginator.total_pages) %}
            {% if count == paginator.page %}
            <span class="current-page">{{ count }}</span>
            {% else %}
            <a href="{{ site.url }}/page{{ count }}">{{ count }}</a>
            {% endif %}
        {% endfor %}
        
        {% if paginator.next_page %}
        <span class="next">
        <a href="{{ site.url }}/{{ paginator.next_page_path }}">Next</a>
        </span>
        {% else %}
        <span class="next disabled">Next</span>
        {% endif %}
    </div>
</div>