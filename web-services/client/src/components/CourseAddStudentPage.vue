<template>
    <div>
      <h2>Fill in the student's information</h2>
      <h4>Social security number</h4>
        <form>
            <input type="ssn" required v-model="ssn" placeholder="SSN">
        </form>
        <h4>First name</h4>
        <form>
            <input type="firstName" required v-model="fName" placeholder="John">
        </form>
        <h4>Last name</h4>
        <form>
            <input type="lastName" required v-model="lName" placeholder="Andersson">
        </form>
        <h4>Email address</h4>
        <form>
            <input type="emailAddress" required v-model="email" placeholder="example@mail.com">
        </form>
        <button @click="addStudent">Submit</button>
    </div>
</template>

<script>
import { Api } from '@/Api'

export default {
  name: 'courseAddStudentPage',
  props: ['courseAddStudentPage'],
  data() {
    return {
      ssn: '',
      fName: '',
      lName: '',
      email: ''
    }
  },
  methods: {
    /**
     * Get the student's information from the form and add the student under the correct course.
     * All the crashes/exceptions/errors shall be handled.
     */
    addStudent() {
      this.validateInput() // NOTE: Ask TA if the error-handling is adequate for full-points
    },
    createIndependentStudentEntityDB() {
      // NOTE: Ask TA if we are expected to CREATE a student here as well, or if we only need to create student in the course-array
      Api.post('/students', {
        SSN: this.ssn,
        firstName: this.fName,
        lastName: this.lName,
        emailAddress: this.email
      })
    },
    enrollExistingStudentInCourseDB() {
      Api.post(`/courses/${this.$route.params.id}/students`, {
        SSN: this.ssn,
        firstName: this.fName,
        lastName: this.lName,
        emailAddress: this.email
      })
    },
    validateInput() {
      if (this.email === '') { // NOTE: Ask TA if more conditions is needed for full points
        this.makeToast('danger', 'Cannot create account, add a valid email.', 'Fail')
      } else {
        this.makeToast('success', 'Account successfully created!', 'Success')
        this.createIndependentStudentEntityDB()
        this.enrollExistingStudentInCourseDB()
      }
    },
    makeToast(variant = null, bodyContent, titleContent) {
      this.$bvToast.toast(bodyContent, {
        title: titleContent,
        variant: variant,
        solid: true
      })
    }
  }
}
</script>

<style scoped>
h2 {
  margin-top: 15px;

}
input {
  border: none;
  outline: none;
  border-radius: 20px;
  font-size: 20m;
  background-color: #e6e6e6;
  color: #333;
  letter-spacing: 1px;
  width: 20rem;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 15px;

}
h4 {
  padding-top: 30px;

}
button {
    color: #fff;
    padding: 14px 64px;
    margin: 32px auto;
    text-transform: uppercase;
    letter-spacing: 2px;
    font-weight: bold;
    border-radius: 10px;
    background-color: darkcyan;
    cursor: pointer;
    transition: opacity 0.4;
  }
  button:hover {
    opacity: 0.9;
  }
@media (max-width: 1000px){
  h2 {
  font-size: 1em;
  margin-top: 15px;
}
h4 {
  font-size: 1em;
  padding-top: 30px;

}
input {
  border-radius: 20px;
  font-size: 1em;
  width: 15rem;

}
button {
  width: 150px;
  padding: 7px 25px;

  }
}
</style>
