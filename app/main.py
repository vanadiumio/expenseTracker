from fastapi import FastAPI

from app.routers.expense import router

app = FastAPI()


@app.get("/health")
def health():
    return {"status": "ok"}

app.include_router(router)
