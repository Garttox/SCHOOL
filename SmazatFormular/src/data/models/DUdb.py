from flask_login import UserMixin
from sqlalchemy.schema import Column
from sqlalchemy.types import Boolean, Integer, String, DATE

from ..database import db
from ..mixins import CRUDModel
from ..util import generate_random_token
from ...settings import app_config
from ...extensions import bcrypt

class DUdata(CRUDModel, UserMixin):
    __tablename__ = 'dudata'

    id = Column(Integer, primary_key=True, autoincrement=True)
    ukol = Column(String(64), nullable=False, index=True)
    predmet = Column(String(64), nullable=False, index=True)
    datum = Column(String(64),nullable=False, index=True)
    # Use custom constructor
    # pylint: disable=W0231
    def __init__(self, **kwargs):
        for k, v in kwargs.iteritems():
            setattr(self, k, v)
