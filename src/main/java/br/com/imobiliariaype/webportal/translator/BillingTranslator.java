package br.com.imobiliariaype.webportal.translator;

import br.com.imobiliariaype.webportal.model.Billing;
import br.com.imobiliariaype.webportal.model.PaidBilling;

import java.util.Date;

public class BillingTranslator {

    private BillingTranslator() {
    }

    public static PaidBilling translateToPaidBilling(Billing billing){
        PaidBilling paidBilling = new PaidBilling();
        paidBilling.setId(billing.getId());
        paidBilling.setValue(billing.getValue());
        paidBilling.setCustomer_id(billing.getCustomer_id());
        paidBilling.setDescription(billing.getDescription());
        paidBilling.setDueDate(billing.getDueDate());
        paidBilling.setRegisterDate(billing.getRegisterDate());
        paidBilling.setPaymentDate(new Date());

        return paidBilling;

    }
}
