import requests
from bs4 import BeautifulSoup

def scrape_top_tech_news():
    url = "https://ycombinator.com"
    # Send an HTTP request to download the webpage content
    response = requests.get(url, headers={"User-Agent": "Mozilla/5.0"})

    if response.status_code != 200:
        return {"error": "Failed to fetch data from source website"}

    soup = BeautifulSoup(response.text, "html.parser")
    articles = []

    # Target the precise CSS container class where Hacker News hides article titles
    links = soup.find_all("span", class_="titleline")

    for index, link in enumerate(links[:10], start=1):
        a_tag = link.find("a")
        if a_tag:
            articles.append({
                "rank": index,
                "title": a_tag.text,
                "url": a_tag["href"]
            })
    return articles
