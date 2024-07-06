import { useForm } from "react-hook-form";
import { api } from "../config_axios";
import { useState, useEffect } from "react";
import InputMask from "react-input-mask";
import { useNavigate } from "react-router-dom";

const Cadastrar_Usuario = () => {
  const { register, handleSubmit, reset } = useForm();
  const [aviso, setAviso] = useState("");
  const [concessionarias, setConcessionarias] = useState([]);
  const [success, setSuccess] = useState(false); // Estado para controlar a mensagem de sucesso
  const navigate = useNavigate(); // Hook para navegação

  useEffect(() => {
    const fetchConcessionarias = async () => {
      try {
        const response = await api.get("/concessionaria");
        setConcessionarias(response.data || []); // Ajustado para garantir que seja um array
        console.log(response.data);
      } catch (error) {
        console.error("Erro ao buscar concessionárias:", error);
        setConcessionarias([]); // Garantir que seja sempre um array
      }
    };
    fetchConcessionarias();
  }, []);

  const salvar = async (campos) => {
    try {
      await api.post("funcionario", campos);
      setAviso("Cadastrado com sucesso!");
      setSuccess(true); // Define o estado de sucesso para true
      reset();
      setTimeout(() => {
        navigate("/"); // Redireciona para a tela de login após 3 segundos
      }, 3000);
    } catch (error) {
      setAviso("Erro ao cadastrar Funcionário!");
    }
  };

  return (
    <div className="container-fluid bg-dark text-light min-vh-100 d-flex align-items-center">
      <div className="container p-5 bg-light text-dark rounded">
        <h4 className="fst-italic mb-3">Cadastrar Funcionários</h4>
        <form onSubmit={handleSubmit(salvar)}>
          <div className="form-group mt-2">
            <label htmlFor="nome">Nome:</label>
            <input
              type="text"
              className="form-control"
              id="nome"
              required
              {...register("nome")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="cpf">CPF:</label>
            <InputMask
              mask="999.999.999-99"
              className="form-control"
              id="cpf"
              required
              {...register("cpf")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="celular">Celular:</label>
            <InputMask
              mask="(99) 99999-9999"
              className="form-control"
              id="celular"
              required
              {...register("celular")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="usuarioDataNascimento">Data de nascimento:</label>
            <input
              type="date"
              className="form-control"
              id="usuarioDataNascimento"
              required
              {...register("usuarioDataNascimento")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              className="form-control"
              id="email"
              required
              {...register("email")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="senha">Senha:</label>
            <input
              type="password"
              className="form-control"
              id="senha"
              required
              {...register("senha")}
            />
          </div>
          {concessionarias.length > 0 && (
            <div className="form-group mt-2">
              <label htmlFor="concessionaria_id">Concessionária:</label>
              <select
                className="form-control"
                id="concessionaria_id"
                required
                {...register("concessionaria_id")}
              >
                <option value="" selected disabled>
                  Selecione uma concessionária
                </option>
                {concessionarias.map((concessionaria) => (
                  <option
                    key={concessionaria.concessionariaId}
                    value={concessionaria.concessionariaId}
                  >
                    {concessionaria.nome}
                  </option>
                ))}
              </select>
            </div>
          )}
          <input
            type="submit"
            className="btn btn-primary mt-3"
            value="Enviar"
          />
          <input
            type="reset"
            className="btn btn-danger mt-3 ms-3"
            value="Limpar"
          />
        </form>
        {aviso && (
          <div
            className={`alert mt-3 ${
              success ? "alert-success" : "alert-danger"
            }`}
          >
            {aviso}
          </div>
        )}
      </div>
    </div>
  );
};

export default Cadastrar_Usuario;
