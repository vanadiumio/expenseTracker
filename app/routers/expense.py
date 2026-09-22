from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session

from app.database import get_db
from app.models.expense import Expense
from app.schemas.expense import ExpenseCreate, ExpenseRead

router = APIRouter()


@router.get("/expense/{item_id}", response_model=ExpenseRead)
def get_expense(item_id: int, db: Session = Depends(get_db)):
    expense = db.get(Expense, item_id)
    if expense is None:
        raise HTTPException(status_code=404, detail=f"Expense {item_id} not found")
    return expense


@router.post("/expense/create", response_model=ExpenseRead)
def create_expense(item: ExpenseCreate, db: Session = Depends(get_db)):
    expense = Expense(**item.model_dump(exclude_none=True))
    db.add(expense)
    db.commit()
    db.refresh(expense)
    return expense
