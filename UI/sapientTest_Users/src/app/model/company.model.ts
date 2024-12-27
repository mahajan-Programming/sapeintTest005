import { CompanyAddress } from "./companyAddress.model";

export interface Company {
    department: string;
    name: string;
    title: string;
    address: CompanyAddress;
  }