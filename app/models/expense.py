import datetime
import decimal

import sqlalchemy
from sqlalchemy import Integer, NUMERIC, String, DateTime, true
from sqlalchemy.orm import Mapped, mapped_column

from app.database import Base


class Expense(Base):
    __tablename__="expense"
    id:Mapped[int]=mapped_column(Integer,primary_key=True)
    amount:Mapped[decimal.Decimal]=mapped_column(NUMERIC(10,2))
    currency:Mapped[str]=mapped_column(String(3))
    description:Mapped[str]=mapped_column(String(200))
    category:Mapped[str]=mapped_column(String(200))
    date:Mapped[datetime.datetime]=mapped_column(DateTime(timezone=True),server_default=sqlalchemy.func.now())
    created_at:Mapped[datetime.datetime]=mapped_column(DateTime(timezone=True),server_default=sqlalchemy.func.now())

