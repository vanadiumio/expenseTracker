import datetime
import decimal
from typing import Optional

from pydantic import BaseModel, ConfigDict, Field


class ExpenseCreate(BaseModel):
    amount:decimal.Decimal
    currency: str= Field(min_length=3, max_length=3)
    description:str= Field(min_length=3, max_length=200)
    category: str= Field(min_length=3, max_length=200)
    date: Optional[datetime.datetime] = Field(default=None)

class ExpenseRead(BaseModel):
    model_config = ConfigDict(from_attributes=True)
    id: int
    amount: decimal.Decimal
    currency: str
    description: str
    category: str
    date: datetime.datetime
    created_at: datetime.datetime