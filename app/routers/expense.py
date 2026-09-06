from fastapi import APIRouter,Depends

from app.database import get_db

router = APIRouter()

@router.get("/expense/{item_id}")
def get_expense(item_id: int,db=Depends(get_db)):
    return db.get(item_id)