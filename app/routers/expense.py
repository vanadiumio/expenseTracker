import http
from http.client import HTTPException

from fastapi import APIRouter,Depends

from app.database import get_db
from app.models.expense import Expense
from app.schemas.expense import ExpenseRead

router = APIRouter()

@router.get("/expense/{item_id}",response_model=ExpenseRead)
def get_expense(item_id: int,db=Depends(get_db)):
        expense = db.get(Expense,item_id)
        if expense is None:
            raise HTTPException(http.HTTPStatus.NOT_FOUND,f"Expense {item_id} not found")
        return expense


