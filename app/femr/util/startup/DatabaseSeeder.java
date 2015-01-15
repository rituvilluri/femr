/*
     fEMR - fast Electronic Medical Records
     Copyright (C) 2014  Team fEMR

     fEMR is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     fEMR is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with fEMR.  If not, see <http://www.gnu.org/licenses/>. If
     you have any questions, contact <info@teamfemr.org>.
*/
package femr.util.startup;

import com.avaje.ebean.Ebean;
import femr.data.daos.IRepository;
import femr.data.daos.Repository;
import femr.data.models.core.*;
import femr.data.models.mysql.*;
import femr.util.calculations.dateUtils;
import femr.util.encryptions.BCryptPasswordEncryptor;
import femr.util.encryptions.IPasswordEncryptor;
import play.Play;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSeeder {

    private final Repository<MedicationMeasurementUnit> medicationMeasurementUnitRepository;
    private final Repository<MedicationForm> medicationFormRepository;
    private final IRepository<MissionCountry> missionCountryRepository;
    private final IRepository<MissionCity> missionCityRepository;
    private final IRepository<MissionTeam> missionTeamRepository;
    private final IRepository<User> userRepository;
    private final Repository<Role> roleRepository;
    private final Repository<SystemSetting> systemSettingRepository;
    private final Repository<TabField> tabFieldRepository;
    private final Repository<TabFieldSize> tabFieldSizeRepository;
    private final Repository<TabFieldType> tabFieldTypeRepository;
    private final Repository<Tab> tabRepository;
    private final Repository<PatientAgeClassification> patientAgeClassificationRepository;

    public DatabaseSeeder() {
        medicationMeasurementUnitRepository = new Repository<>();
        medicationFormRepository = new Repository<>();
        userRepository = new Repository<>();
        roleRepository = new Repository<>();
        systemSettingRepository = new Repository<>();
        tabFieldRepository = new Repository<>();
        tabFieldSizeRepository = new Repository<>();
        tabFieldTypeRepository = new Repository<>();
        tabRepository = new Repository<>();
        patientAgeClassificationRepository = new Repository<>();
        missionCountryRepository = new Repository<>();
        missionTeamRepository = new Repository<>();
        missionCityRepository = new Repository<>();
    }

    public void seed() {
        seedMissionTripInformation();
        seedSystemSettings();
        seedAdminUser();
        seedDefaultTabNames();
        seedTabFieldTypesAndSizes();
        seedDefaultTabFields();
        seedMedicationUnits();
        seedMedicationForms();
        seedPatientAgeClassification();
    }

    private void seedMissionTripInformation() {
        //mission countries
        List<? extends IMissionCountry> missionCountries = missionCountryRepository.findAll(MissionCountry.class);
        List<String> availableCountries = new ArrayList<>();

        availableCountries.add("Afghanistan");
        availableCountries.add("Albania");
        availableCountries.add("Algeria");
        availableCountries.add("Andorra");
        availableCountries.add("Angola");
        availableCountries.add("Antigua & Deps");
        availableCountries.add("Argentina");
        availableCountries.add("Armenia");
        availableCountries.add("Australia");
        availableCountries.add("Austria");
        availableCountries.add("Azerbaijan");
        availableCountries.add("Bahamas");
        availableCountries.add("Bahrain");
        availableCountries.add("Bangladesh");
        availableCountries.add("Barbados");
        availableCountries.add("Belarus");
        availableCountries.add("Belgium");
        availableCountries.add("Belize");
        availableCountries.add("Benin");
        availableCountries.add("Bhutan");
        availableCountries.add("Bolivia");
        availableCountries.add("Bosnia Herzegovina");
        availableCountries.add("Botswana");
        availableCountries.add("Brazil");
        availableCountries.add("Brunei");
        availableCountries.add("Bulgaria");
        availableCountries.add("Burkina");
        availableCountries.add("Burundi");
        availableCountries.add("Cambodia");
        availableCountries.add("Cameroon");
        availableCountries.add("Canada");
        availableCountries.add("Cape Verde");
        availableCountries.add("Central African Rep");
        availableCountries.add("Chad");
        availableCountries.add("Chile");
        availableCountries.add("China");
        availableCountries.add("Colombia");
        availableCountries.add("Comoros");
        availableCountries.add("Congo");
        availableCountries.add("Congo {Democratic Rep}");
        availableCountries.add("Costa Rica");
        availableCountries.add("Croatia");
        availableCountries.add("Cuba");
        availableCountries.add("Cyprus");
        availableCountries.add("Czech Republic");
        availableCountries.add("Denmark");
        availableCountries.add("Djibouti");
        availableCountries.add("Dominica");
        availableCountries.add("Dominican Republic");
        availableCountries.add("East Timor");
        availableCountries.add("Ecuador");
        availableCountries.add("Egypt");
        availableCountries.add("El Salvador");
        availableCountries.add("Equatorial Guinea");
        availableCountries.add("Eritrea");
        availableCountries.add("Estonia");
        availableCountries.add("Ethiopia");
        availableCountries.add("Fiji");
        availableCountries.add("Finland");
        availableCountries.add("France");
        availableCountries.add("Gabon");
        availableCountries.add("Gambia");
        availableCountries.add("Georgia");
        availableCountries.add("Germany");
        availableCountries.add("Ghana");
        availableCountries.add("Greece");
        availableCountries.add("Grenada");
        availableCountries.add("Guatemala");
        availableCountries.add("Guinea");
        availableCountries.add("Guinea-Bissau");
        availableCountries.add("Guyana");
        availableCountries.add("Haiti");
        availableCountries.add("Honduras");
        availableCountries.add("Hungary");
        availableCountries.add("Iceland");
        availableCountries.add("India");
        availableCountries.add("Indonesia");
        availableCountries.add("Iran");
        availableCountries.add("Iraq");
        availableCountries.add("Ireland {Republic}");
        availableCountries.add("Israel");
        availableCountries.add("Italy");
        availableCountries.add("Ivory Coast");
        availableCountries.add("Jamaica");
        availableCountries.add("Japan");
        availableCountries.add("Jordan");
        availableCountries.add("Kazakhstan");
        availableCountries.add("Kenya");
        availableCountries.add("Kiribati");
        availableCountries.add("Korea North");
        availableCountries.add("Korea South");
        availableCountries.add("Kosovo");
        availableCountries.add("Kuwait");
        availableCountries.add("Kyrgyzstan");
        availableCountries.add("Laos");
        availableCountries.add("Latvia");
        availableCountries.add("Lebanon");
        availableCountries.add("Lesotho");
        availableCountries.add("Liberia");
        availableCountries.add("Libya");
        availableCountries.add("Liechtenstein");
        availableCountries.add("Lithuania");
        availableCountries.add("Luxembourg");
        availableCountries.add("Macedonia");
        availableCountries.add("Madagascar");
        availableCountries.add("Malawi");
        availableCountries.add("Malaysia");
        availableCountries.add("Maldives");
        availableCountries.add("Mali");
        availableCountries.add("Malta");
        availableCountries.add("Marshall Islands");
        availableCountries.add("Mauritania");
        availableCountries.add("Mauritius");
        availableCountries.add("Mexico");
        availableCountries.add("Micronesia");
        availableCountries.add("Moldova");
        availableCountries.add("Monaco");
        availableCountries.add("Mongolia");
        availableCountries.add("Montenegro");
        availableCountries.add("Morocco");
        availableCountries.add("Mozambique");
        availableCountries.add("Myanmar, {Burma}");
        availableCountries.add("Namibia");
        availableCountries.add("Nauru");
        availableCountries.add("Nepal");
        availableCountries.add("Netherlands");
        availableCountries.add("New Zealand");
        availableCountries.add("Nicaragua");
        availableCountries.add("Niger");
        availableCountries.add("Nigeria");
        availableCountries.add("Norway");
        availableCountries.add("Oman");
        availableCountries.add("Pakistan");
        availableCountries.add("Palau");
        availableCountries.add("Panama");
        availableCountries.add("Papua New Guinea");
        availableCountries.add("Paraguay");
        availableCountries.add("Peru");
        availableCountries.add("Philippines");
        availableCountries.add("Poland");
        availableCountries.add("Portugal");
        availableCountries.add("Qatar");
        availableCountries.add("Romania");
        availableCountries.add("Russian Federation");
        availableCountries.add("Rwanda");
        availableCountries.add("St Kitts & Nevis");
        availableCountries.add("St Lucia");
        availableCountries.add("Saint Vincent & the Grenadines");
        availableCountries.add("Samoa");
        availableCountries.add("San Marino");
        availableCountries.add("Sao Tome & Principe");
        availableCountries.add("Saudi Arabia");
        availableCountries.add("Senegal");
        availableCountries.add("Serbia");
        availableCountries.add("Seychelles");
        availableCountries.add("Sierra Leone");
        availableCountries.add("Singapore");
        availableCountries.add("Slovakia");
        availableCountries.add("Slovenia");
        availableCountries.add("Solomon Islands");
        availableCountries.add("Somalia");
        availableCountries.add("South Africa");
        availableCountries.add("South Sudan");
        availableCountries.add("Spain");
        availableCountries.add("Sri Lanka");
        availableCountries.add("Sudan");
        availableCountries.add("Suriname");
        availableCountries.add("Swaziland");
        availableCountries.add("Sweden");
        availableCountries.add("Switzerland");
        availableCountries.add("Syria");
        availableCountries.add("Taiwan");
        availableCountries.add("Tajikistan");
        availableCountries.add("Tanzania");
        availableCountries.add("Thailand");
        availableCountries.add("Togo");
        availableCountries.add("Tonga");
        availableCountries.add("Trinidad & Tobago");
        availableCountries.add("Tunisia");
        availableCountries.add("Turkey");
        availableCountries.add("Turkmenistan");
        availableCountries.add("Tuvalu");
        availableCountries.add("Uganda");
        availableCountries.add("Ukraine");
        availableCountries.add("United Arab Emirates");
        availableCountries.add("United Kingdom");
        availableCountries.add("USA");
        availableCountries.add("Uruguay");
        availableCountries.add("Uzbekistan");
        availableCountries.add("Vanuatu");
        availableCountries.add("Vatican City");
        availableCountries.add("Venezuela");
        availableCountries.add("Vietnam");
        availableCountries.add("Yemen");
        availableCountries.add("Zambia");
        availableCountries.add("Zimbabwe");

        List<MissionCountry> newMissionCountries = new ArrayList<>();
        MissionCountry missionCountry;

        for (String country : availableCountries){
            if (missionCountries != null && !containMissionCountry(missionCountries, country)) {
                missionCountry = new MissionCountry();
                missionCountry.setName(country);
                newMissionCountries.add(missionCountry);
            }
        }

        missionCountryRepository.createAll(newMissionCountries);
        missionCountries = missionCountryRepository.findAll(MissionCountry.class);

        //mission teams
        List<? extends IMissionTeam> missionTeams = missionTeamRepository.findAll(MissionTeam.class);
        List<MissionTeam> newMissionTeams = new ArrayList<>();
        MissionTeam missionTeam;
        if (missionTeams != null && !containMissionTeam(missionTeams, "Aid for Haiti"))
        {
            missionTeam = new MissionTeam();
            missionTeam.setName("Aid for Haiti");
            missionTeam.setLocation("Tennessee");
            missionTeam.setDescription("Dr. Sutherland's group");
            newMissionTeams.add(missionTeam);
        }
        if (missionTeams != null && !containMissionTeam(missionTeams, "WSU-WHSO"))
        {
            missionTeam = new MissionTeam();
            missionTeam.setName("WSU-WHSO");
            missionTeam.setLocation("Detroit");
            missionTeam.setDescription("Wayne State medical students");
            newMissionTeams.add(missionTeam);
        }
        if (missionTeams != null && !containMissionTeam(missionTeams, "ApParent Project"))
        {
            missionTeam = new MissionTeam();
            missionTeam.setName("ApParent Project");
            missionTeam.setLocation("New York");
            missionTeam.setDescription("Dr. Parson's group - primarily operates in Port Au Prince");
            newMissionTeams.add(missionTeam);
        }
        missionTeamRepository.createAll(newMissionTeams);

        //countries
        List<? extends IMissionCity> missionCities = missionCityRepository.findAll(MissionCity.class);
        List<MissionCity> newMissionCities = new ArrayList<>();

        MissionCity missionCity;
        if (missionCities != null && !containMissionCity(missionCities, "Morne De L' Hopital", "Haiti")){
            missionCity = new MissionCity();
            missionCity.setName("Morne De L' Hopital");
            missionCity.setMissionCountry(getMissionCountry(missionCountries, "Haiti"));
            newMissionCities.add(missionCity);
        }
        if (missionCities != null && !containMissionCity(missionCities, "Port-au-Prince", "Haiti")){
            missionCity = new MissionCity();
            missionCity.setName("Port-au-Prince");
            missionCity.setMissionCountry(getMissionCountry(missionCountries, "Haiti"));
            newMissionCities.add(missionCity);
        }
        missionCityRepository.createAll(newMissionCities);

    }

    private void seedPatientAgeClassification() {
        //sort order auto increments
        List<? extends IPatientAgeClassification> patientAgeClassifications = patientAgeClassificationRepository.findAll(PatientAgeClassification.class);

        List<PatientAgeClassification> newPatientAgeClassifications = new ArrayList<>();
        PatientAgeClassification patientAgeClassification;
        if (patientAgeClassifications != null && !containClassification(patientAgeClassifications, "infant")) {
            patientAgeClassification = new PatientAgeClassification();
            patientAgeClassification.setName("infant");
            patientAgeClassification.setDescription("0-1");
            patientAgeClassification.setIsDeleted(false);
            patientAgeClassification.setSortOrder(1);
            newPatientAgeClassifications.add(patientAgeClassification);
        }
        if (patientAgeClassifications != null && !containClassification(patientAgeClassifications, "child")) {
            patientAgeClassification = new PatientAgeClassification();
            patientAgeClassification.setName("child");
            patientAgeClassification.setDescription("2-12");
            patientAgeClassification.setIsDeleted(false);
            patientAgeClassification.setSortOrder(2);
            newPatientAgeClassifications.add(patientAgeClassification);
        }
        if (patientAgeClassifications != null && !containClassification(patientAgeClassifications, "teen")) {
            patientAgeClassification = new PatientAgeClassification();
            patientAgeClassification.setName("teen");
            patientAgeClassification.setDescription("13-17");
            patientAgeClassification.setIsDeleted(false);
            patientAgeClassification.setSortOrder(3);
            newPatientAgeClassifications.add(patientAgeClassification);
        }
        if (patientAgeClassifications != null && !containClassification(patientAgeClassifications, "adult")) {
            patientAgeClassification = new PatientAgeClassification();
            patientAgeClassification.setName("adult");
            patientAgeClassification.setDescription("18-64");
            patientAgeClassification.setIsDeleted(false);
            patientAgeClassification.setSortOrder(4);
            newPatientAgeClassifications.add(patientAgeClassification);
        }
        if (patientAgeClassifications != null && !containClassification(patientAgeClassifications, "elder")) {
            patientAgeClassification = new PatientAgeClassification();
            patientAgeClassification.setName("elder");
            patientAgeClassification.setDescription("65+");
            patientAgeClassification.setIsDeleted(false);
            patientAgeClassification.setSortOrder(5);
            newPatientAgeClassifications.add(patientAgeClassification);
        }
        patientAgeClassificationRepository.createAll(newPatientAgeClassifications);
    }

    private void seedMedicationForms() {

        List<? extends IMedicationForm> medicationForms = medicationFormRepository.findAll(MedicationForm.class);

        List<MedicationForm> newMedicationForms = new ArrayList<>();
        MedicationForm medicationForm;
        if (medicationForms != null && !containForm(medicationForms, "B/S")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("B/S");
            medicationForm.setDescription("bite and swallow");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "caps")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("caps");
            medicationForm.setDescription("capsules");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "crm")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("crm");
            medicationForm.setDescription("cream");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "elix")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("elix");
            medicationForm.setDescription("elixir");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "gtts")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("gtts");
            medicationForm.setDescription("drops");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "MDI")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("MDI");
            medicationForm.setDescription("metered dose inhaler");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "nebs")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("nebs");
            medicationForm.setDescription("solution for nebulization");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "NPO")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("NPO");
            medicationForm.setDescription("nothing by mouth");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "PO")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("PO");
            medicationForm.setDescription("by mouth, orally , or swallowed");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "PR")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("PR");
            medicationForm.setDescription("suppository");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "SL")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("SL");
            medicationForm.setDescription("sublingual form");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "soln")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("soln");
            medicationForm.setDescription("solution");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "supp")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("supp");
            medicationForm.setDescription("suppository");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "susp")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("susp");
            medicationForm.setDescription("suspension");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "syr")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("syr");
            medicationForm.setDescription("syrup");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "tabs")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("tabs");
            medicationForm.setDescription("tablets");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        if (medicationForms != null && !containForm(medicationForms, "ung")) {
            medicationForm = new MedicationForm();
            medicationForm.setName("ung");
            medicationForm.setDescription("ointment");
            medicationForm.setIsDeleted(false);
            newMedicationForms.add(medicationForm);
        }
        medicationFormRepository.createAll(newMedicationForms);
    }

    private void seedMedicationUnits() {
        List<? extends IMedicationMeasurementUnit> medicationUnits = medicationMeasurementUnitRepository.findAll(MedicationMeasurementUnit.class);

        List<MedicationMeasurementUnit> newMedicationMeasurementUnits = new ArrayList<>();
        MedicationMeasurementUnit medicationMeasurementUnit;
        if (medicationUnits != null && !containUnit(medicationUnits, "%")) {
            medicationMeasurementUnit = new MedicationMeasurementUnit();
            medicationMeasurementUnit.setName("%");
            medicationMeasurementUnit.setDescription("g/dL");
            medicationMeasurementUnit.setIsDeleted(false);
            newMedicationMeasurementUnits.add(medicationMeasurementUnit);
        }
        if (medicationUnits != null && !containUnit(medicationUnits, "g")) {
            medicationMeasurementUnit = new MedicationMeasurementUnit();
            medicationMeasurementUnit.setName("g");
            medicationMeasurementUnit.setDescription("gram");
            medicationMeasurementUnit.setIsDeleted(false);
            newMedicationMeasurementUnits.add(medicationMeasurementUnit);
        }
        if (medicationUnits != null && !containUnit(medicationUnits, "gr")) {
            medicationMeasurementUnit = new MedicationMeasurementUnit();
            medicationMeasurementUnit.setName("gr");
            medicationMeasurementUnit.setDescription("grain");
            medicationMeasurementUnit.setIsDeleted(false);
            newMedicationMeasurementUnits.add(medicationMeasurementUnit);
        }
        if (medicationUnits != null && !containUnit(medicationUnits, "IU")) {
            medicationMeasurementUnit = new MedicationMeasurementUnit();
            medicationMeasurementUnit.setName("IU");
            medicationMeasurementUnit.setDescription("international units");
            medicationMeasurementUnit.setIsDeleted(false);
            newMedicationMeasurementUnits.add(medicationMeasurementUnit);
        }
        if (medicationUnits != null && !containUnit(medicationUnits, "mg")) {
            medicationMeasurementUnit = new MedicationMeasurementUnit();
            medicationMeasurementUnit.setName("mg");
            medicationMeasurementUnit.setDescription("milligram");
            medicationMeasurementUnit.setIsDeleted(false);
            newMedicationMeasurementUnits.add(medicationMeasurementUnit);
        }
        if (medicationUnits != null && !containUnit(medicationUnits, "U")) {
            medicationMeasurementUnit = new MedicationMeasurementUnit();
            medicationMeasurementUnit.setName("U");
            medicationMeasurementUnit.setDescription("unit");
            medicationMeasurementUnit.setIsDeleted(false);
            newMedicationMeasurementUnits.add(medicationMeasurementUnit);
        }
        medicationMeasurementUnitRepository.createAll(newMedicationMeasurementUnits);
    }


    /**
     * Seed available system settings
     */
    private void seedSystemSettings() {
        List<? extends ISystemSetting> systemSettings = systemSettingRepository.findAll(SystemSetting.class);

        SystemSetting systemSetting;
        if (systemSettings != null && !containSetting(systemSettings, "Multiple chief complaints")) {
            systemSetting = new SystemSetting();
            systemSetting.setName("Multiple chief complaints");
            systemSetting.setActive(false);
            systemSettingRepository.create(systemSetting);
        }
        if (systemSettings != null && !containSetting(systemSettings, "Medical PMH Tab")) {
            systemSetting = new SystemSetting();
            systemSetting.setName("Medical PMH Tab");
            systemSetting.setActive(true);
            systemSettingRepository.create(systemSetting);
        }
        if (systemSettings != null && !containSetting(systemSettings, "Medical Photo Tab")) {
            systemSetting = new SystemSetting();
            systemSetting.setName("Medical Photo Tab");
            systemSetting.setActive(true);
            systemSettingRepository.create(systemSetting);
        }
        if (systemSettings != null && !containSetting(systemSettings, "Medical HPI Consolidate")) {
            systemSetting = new SystemSetting();
            systemSetting.setName("Medical HPI Consolidate");
            systemSetting.setActive(false);
            systemSettingRepository.create(systemSetting);
        }
    }

    private static IMissionCountry getMissionCountry(List<? extends IMissionCountry> missionCountries, String countryName) {
        for (IMissionCountry mc : missionCountries) {
            if (mc.getName().toLowerCase().equals(countryName.toLowerCase())) {
                return mc;
            }
        }
        return null;
    }

    private static boolean containMissionCity(List<? extends IMissionCity> missionCities, String cityName, String countryName) {
        for (IMissionCity mc : missionCities) {
            if (mc.getName().toLowerCase().equals(cityName.toLowerCase()) && mc.getMissionCountry().getName().toLowerCase().equals(countryName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private static boolean containMissionTeam(List<? extends IMissionTeam> missionTeams, String name) {
        for (IMissionTeam mt : missionTeams) {
            if (mt.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containMissionCountry(List<? extends IMissionCountry> missionCountries, String name) {
        for (IMissionCountry mc : missionCountries) {
            if (mc.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containClassification(List<? extends IPatientAgeClassification> ageClassifications, String name) {
        for (IPatientAgeClassification pac : ageClassifications) {
            if (pac.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containForm(List<? extends IMedicationForm> medicationForms, String form) {
        for (IMedicationForm mf : medicationForms) {
            if (mf.getName().equals(form)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containUnit(List<? extends IMedicationMeasurementUnit> medicationMeasurementUnits, String unit) {
        for (IMedicationMeasurementUnit mmu : medicationMeasurementUnits) {
            if (mmu.getName().equals(unit)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containSetting(List<? extends ISystemSetting> systemSettings, String setting) {
        for (ISystemSetting ss : systemSettings) {
            if (ss.getName().equals(setting)) {
                return true;
            }
        }
        return false;
    }


    private void seedDefaultTabFields() {
        int sizeCount = tabFieldRepository.count(TabField.class);
        if (sizeCount == 0) {
            List<TabField> tabFields = new ArrayList<>();
            TabField tabField = new TabField();
            tabField.setName("onset");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("severity");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 2));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("radiation");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("quality");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("provokes");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("palliates");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("timeOfDay");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("physicalExamination");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("narrative");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 1));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("assessment");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 3));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("problem");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 3));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("treatment");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 3));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("medicalSurgicalHistory");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 2));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("socialHistory");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 2));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("currentMedication");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 2));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabField = new TabField();
            tabField.setName("familyHistory");
            tabField.setIsDeleted(false);
            tabField.setTab(Ebean.getReference(Tab.class, 2));
            tabField.setTabFieldType(Ebean.getReference(TabFieldType.class, 1));
            tabFields.add(tabField);

            tabFieldRepository.createAll(tabFields);
        }

    }


    private void seedDefaultTabNames() {
        int sizeCount = tabRepository.count(Tab.class);
        if (sizeCount == 0) {
            List<Tab> tabs = new ArrayList<>();
            Tab tab = new Tab();
            tab.setName("HPI");
            tab.setId(1);
            tab.setIsDeleted(false);
            tab.setDateCreated(dateUtils.getCurrentDateTime());
            tab.setUserId(null);
            tab.setLeftColumnSize(2);
            tab.setRightColumnSize(2);
            tab.setIsCustom(false);
            tabs.add(tab);

            tab = new Tab();
            tab.setName("PMH");
            tab.setId(2);
            tab.setIsDeleted(false);
            tab.setDateCreated(dateUtils.getCurrentDateTime());
            tab.setUserId(null);
            tab.setLeftColumnSize(0);
            tab.setRightColumnSize(0);
            tab.setIsCustom(false);
            tabs.add(tab);

            tab = new Tab();
            tab.setName("Treatment");
            tab.setId(3);
            tab.setIsDeleted(false);
            tab.setDateCreated(dateUtils.getCurrentDateTime());
            tab.setUserId(null);
            tab.setLeftColumnSize(0);
            tab.setRightColumnSize(0);
            tab.setIsCustom(false);
            tabs.add(tab);

            tab = new Tab();
            tab.setName("Photos");
            tab.setId(4);
            tab.setIsDeleted(false);
            tab.setDateCreated(dateUtils.getCurrentDateTime());
            tab.setUserId(null);
            tab.setLeftColumnSize(0);
            tab.setRightColumnSize(0);
            tab.setIsCustom(false);
            tabs.add(tab);

            tabRepository.createAll(tabs);
        }

    }

    /**
     * Seed initial tab field values
     */
    private void seedTabFieldTypesAndSizes() {
        int sizeCount = tabFieldSizeRepository.count(TabFieldSize.class);
        if (sizeCount == 0) {
            List<TabFieldSize> tabFieldSizes = new ArrayList<>();
            TabFieldSize tabFieldSize = new TabFieldSize();
            //not using small right now
//            tabFieldSize.setName("small");
//            tabFieldSizes.add(tabFieldSize);

            tabFieldSize = new TabFieldSize();
            tabFieldSize.setName("medium");
            tabFieldSizes.add(tabFieldSize);

            tabFieldSize = new TabFieldSize();
            tabFieldSize.setName("large");
            tabFieldSizes.add(tabFieldSize);

            tabFieldSizeRepository.createAll(tabFieldSizes);
        }
        sizeCount = tabFieldTypeRepository.count(TabFieldType.class);
        if (sizeCount == 0) {
            List<TabFieldType> tabFieldTypes = new ArrayList<>();

            TabFieldType tabFieldType = new TabFieldType();
            tabFieldType.setName("text");
            tabFieldType.setId(1);
            tabFieldTypes.add(tabFieldType);

            tabFieldType = new TabFieldType();
            tabFieldType.setName("number");
            tabFieldType.setId(2);
            tabFieldTypes.add(tabFieldType);

            tabFieldTypeRepository.createAll(tabFieldTypes);
        }

    }

    /**
     * Seed the admin user from the configuration file
     * and the super user information.
     */
    private void seedAdminUser() {
        int userCount = userRepository.count(User.class);

        if (userCount == 0) {
            String defaultAdminUsername = Play.application().configuration().getString("default.admin.username");
            String defaultAdminPassword = Play.application().configuration().getString("default.admin.password");
            IPasswordEncryptor encryptor = new BCryptPasswordEncryptor();

            //create the Admin user
            //Admin is used for managing users, creating users, managing inventory, etc
            //Admin information is given to the manager/group leader/whoever is in charge
            User adminUser = new User();
            String encryptedPassword = encryptor.encryptPassword(defaultAdminPassword);
            adminUser.setFirstName("Administrator");
            adminUser.setLastName("");
            adminUser.setEmail(defaultAdminUsername);
            adminUser.setPassword(encryptedPassword);
            adminUser.setLastLogin(dateUtils.getCurrentDateTime());
            adminUser.setDeleted(false);
            Role role = roleRepository.findOne(Ebean.find(Role.class).where().eq("name", "Administrator"));
            adminUser.addRole(role);
            adminUser.setPasswordReset(false);
            userRepository.create(adminUser);

            //SuperUser is currently only used for managing dynamic tabs on the medical page
            //SuperUser is an account that gives access to important configuration
            //settings
            User superUser = new User();
            String encryptedSuperUserPassword = encryptor.encryptPassword("wsu1f8e6m8r");
            superUser.setFirstName("SuperUser");
            superUser.setLastName("");
            superUser.setEmail("superuser");
            superUser.setPassword(encryptedSuperUserPassword);
            superUser.setLastLogin(dateUtils.getCurrentDateTime());
            superUser.setDeleted(false);
            Role role1 = roleRepository.findOne(Ebean.find(Role.class).where().eq("name", "SuperUser"));
            superUser.addRole(role1);
            superUser.setPasswordReset(false);
            userRepository.create(superUser);
        }
    }
}
