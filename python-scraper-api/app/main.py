from fastapi import FastAPI
from app.scraper import scrape_top_tech_news

app = FastAPI(title="ZCAS Student Tech News Scraper API")

@app.get("/")
def read_root():
    return {
        "status": "online",
        "message": "Welcome to the Python News Scraper API workspace."
    }

@app.get("/api/news")
def get_scraped_news():
    data = scrape_top_tech_news()
    return {
        "source": "HackerNews",
        "total_results": len(data),
        "articles": data
    }
