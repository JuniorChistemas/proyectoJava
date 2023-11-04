USE [ProyectoFinal]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[IdCliente] [char](50) NOT NULL,
	[IdPersona] [char](50) NULL,
	[FechaInicio] [datetime] NULL,
	[Observaciones] [nchar](300) NULL,
	[Estado] [bit] NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[IdCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Persona]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Persona](
	[IdPersona] [char](50) NOT NULL,
	[Nombre] [nchar](30) NULL,
	[Apellido] [nchar](60) NULL,
	[TipoDocumento_P] [char](50) NULL,
	[NumeroDocumento] [nchar](10) NULL,
	[Celular] [nchar](9) NULL,
	[Correo] [nchar](30) NULL,
	[Genero] [bit] NULL,
	[FechaNacimiento] [datetime] NULL,
	[Direccion] [nchar](250) NULL,
	[IdParametro] [char](50) NULL,
	[Estado] [bit] NULL,
 CONSTRAINT [PK_Persona] PRIMARY KEY CLUSTERED 
(
	[IdPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Cliente_View]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Cliente_View]
AS
SELECT C.IdCliente, P.IdPersona, P.Nombre, P.TipoDocumento_P,
CASE WHEN C.Estado = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END AS Estado
FROM     dbo.Persona AS P INNER JOIN
                  dbo.Cliente AS C ON P.IdPersona = C.IdPersona;
GO
/****** Object:  UserDefinedFunction [dbo].[Buscar]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[Buscar](@Numero NCHAR(100))
RETURNS TABLE
AS
		RETURN(	SELECT C.IdCliente,P.IdPersona,P.Nombre,P.Apellido,P.TipoDocumento_P,P.NumeroDocumento,P.Celular,FORMAT(P.FechaNacimiento,'D')
					AS 'Fecha Nacimiento', FORMAT(C.FechaInicio,'D')AS 'Inicio',
					CASE
						WHEN C.Estado=1 THEN 'ACTIVO'
							ELSE 'INACTIVO'
						END 'Estado'
				FROM Persona AS P
				inner join Cliente AS C on P.IdPersona = C.IdPersona WHERE P.NumeroDocumento=@Numero);
GO
/****** Object:  Table [dbo].[Parametro]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parametro](
	[IdParametro] [char](50) NOT NULL,
	[DescripcionP] [nchar](30) NULL,
	[TipoP] [char](50) NULL,
	[Estado] [bit] NULL,
 CONSTRAINT [PK_Parametro] PRIMARY KEY CLUSTERED 
(
	[IdParametro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Parametro_View]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Parametro_View]
AS
	SELECT P.IdParametro,P.DescripcionP,P.TipoP,CASE WHEN P.Estado=1 THEN 'Activo' ELSE 'Inactivo' END AS Estado FROM Parametro AS P
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[IdUsuario] [char](50) NOT NULL,
	[IdPersona] [char](50) NULL,
	[Sueldo] [decimal](18, 2) NULL,
	[Password] [char](10) NULL,
	[TipoContrato_P] [char](50) NULL,
	[IdParametro] [char](50) NULL,
	[Estado] [bit] NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[ViewUsuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ViewUsuario]
AS
	SELECT U.IdUsuario,U.IdPersona,U.TipoContrato_P,U.Sueldo,CASE WHEN U.Estado=1 THEN 'ACTIVO' ELSE 'INACTIVO' END AS Genero FROM Usuario AS U
GO
/****** Object:  View [dbo].[ListarCategoria]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ListarCategoria]
AS
	SELECT P.IdParametro,P.DescripcionP,P.TipoP,CASE WHEN P.Estado = 1 THEN 'Activo' ELSE 'Inactivo' END AS Estado FROM Parametro AS P WHERE DescripcionP = 'CATEGORIA';
GO
/****** Object:  View [dbo].[ListarMarca]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ListarMarca]
AS
	SELECT P.IdParametro,P.DescripcionP,P.TipoP,CASE WHEN P.Estado = 1 THEN 'Activo' ELSE 'Inactivo' END AS Estado FROM Parametro AS P WHERE P.DescripcionP='MARCA';
GO
/****** Object:  Table [dbo].[Producto]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[IdProducto] [char](50) NOT NULL,
	[Nombre] [nchar](350) NULL,
	[Categoria_P] [char](50) NULL,
	[Estado] [bit] NULL,
	[Stock] [int] NULL,
	[Precio_Venta] [decimal](18, 3) NULL,
	[IdParametro] [char](50) NULL,
 CONSTRAINT [PK_Producto] PRIMARY KEY CLUSTERED 
(
	[IdProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[ViewProducto]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ViewProducto]
AS
SELECT IdProducto, Nombre, Categoria_P, CASE WHEN P.Estado = 1 THEN 'Activo' ELSE 'Inactivo' END AS Estado, Stock, Precio_Venta
FROM     dbo.Producto AS P
GO
/****** Object:  View [dbo].[ProductosVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ProductosVenta]
AS
	SELECT P.IdProducto,P.Nombre,P.Stock,P.Precio_Venta FROM Producto AS P WHERE P.Estado = 1;
GO
/****** Object:  Table [dbo].[DetalleVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleVenta](
	[IdVenta] [char](50) NULL,
	[IdProducto] [char](50) NULL,
	[Cantidad] [int] NULL,
	[PrecioUni] [decimal](11, 3) NULL,
	[Descuento] [decimal](11, 3) NULL,
	[ImporteTotal] [decimal](18, 3) NULL
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[ViewDetalleVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ViewDetalleVenta]
AS
	SELECT Det.IdProducto,P.Nombre,Det.Cantidad,Det.Descuento,Det.ImporteTotal FROM DetalleVenta AS Det
	INNER JOIN Producto AS P ON Det.IdProducto = P.IdProducto
GO
/****** Object:  Table [dbo].[Proveedor]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proveedor](
	[IdProveedor] [char](50) NOT NULL,
	[IdPersona] [char](50) NULL,
	[Observaciones] [nchar](150) NULL,
	[Referencias] [nchar](150) NULL,
	[Estado] [bit] NULL,
 CONSTRAINT [PK_Proveedor] PRIMARY KEY CLUSTERED 
(
	[IdProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[ViewProveedor]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ViewProveedor]
AS
	SELECT EE.IdProveedor,EE.IdPersona,P.Nombre,P.TipoDocumento_P FROM Persona AS P INNER JOIN Proveedor AS EE ON P.IdPersona = EE.IdPersona
GO
/****** Object:  Table [dbo].[DetalleOrdenCompra]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleOrdenCompra](
	[IdProducto] [char](50) NULL,
	[Cantidad] [int] NULL,
	[PrecioCompra] [decimal](18, 3) NULL,
	[ImporteTotal] [decimal](18, 3) NULL,
	[IdOrdenCompra] [char](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrdenCompra]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrdenCompra](
	[IdOrdenCompra] [char](50) NOT NULL,
	[MarcaP] [char](50) NULL,
	[MontoTotal] [decimal](18, 3) NULL,
	[fecha] [datetime] NULL,
	[IdProveedor] [char](50) NULL,
	[IdParametro] [char](50) NULL,
	[Estado] [bit] NULL,
 CONSTRAINT [PK_OrdenCompra] PRIMARY KEY CLUSTERED 
(
	[IdOrdenCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Venta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Venta](
	[IdVenta] [char](50) NOT NULL,
	[IdUsuario] [char](50) NULL,
	[IdCliente] [char](50) NULL,
	[Fecha] [datetime] NULL,
	[TipoComprovante] [nchar](20) NULL,
	[MontoTotal] [decimal](18, 3) NULL,
	[Impuesto] [decimal](10, 3) NULL,
	[Estado] [bit] NULL,
 CONSTRAINT [PK_Venta] PRIMARY KEY CLUSTERED 
(
	[IdVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_Persona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[Persona] ([IdPersona])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_Persona]
GO
ALTER TABLE [dbo].[DetalleOrdenCompra]  WITH CHECK ADD  CONSTRAINT [FK_DetalleOrdenCompra_OrdenCompra] FOREIGN KEY([IdOrdenCompra])
REFERENCES [dbo].[OrdenCompra] ([IdOrdenCompra])
GO
ALTER TABLE [dbo].[DetalleOrdenCompra] CHECK CONSTRAINT [FK_DetalleOrdenCompra_OrdenCompra]
GO
ALTER TABLE [dbo].[DetalleOrdenCompra]  WITH CHECK ADD  CONSTRAINT [FK_DetalleProducto_Producto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[DetalleOrdenCompra] CHECK CONSTRAINT [FK_DetalleProducto_Producto]
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD  CONSTRAINT [FK_DetalleVenta_Producto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[DetalleVenta] CHECK CONSTRAINT [FK_DetalleVenta_Producto]
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD  CONSTRAINT [FK_DetalleVenta_Venta] FOREIGN KEY([IdVenta])
REFERENCES [dbo].[Venta] ([IdVenta])
GO
ALTER TABLE [dbo].[DetalleVenta] CHECK CONSTRAINT [FK_DetalleVenta_Venta]
GO
ALTER TABLE [dbo].[OrdenCompra]  WITH CHECK ADD  CONSTRAINT [FK_OrdenCompra_Parametro] FOREIGN KEY([IdParametro])
REFERENCES [dbo].[Parametro] ([IdParametro])
GO
ALTER TABLE [dbo].[OrdenCompra] CHECK CONSTRAINT [FK_OrdenCompra_Parametro]
GO
ALTER TABLE [dbo].[OrdenCompra]  WITH CHECK ADD  CONSTRAINT [FK_OrdenCompra_Proveedor] FOREIGN KEY([IdProveedor])
REFERENCES [dbo].[Proveedor] ([IdProveedor])
GO
ALTER TABLE [dbo].[OrdenCompra] CHECK CONSTRAINT [FK_OrdenCompra_Proveedor]
GO
ALTER TABLE [dbo].[Persona]  WITH CHECK ADD  CONSTRAINT [FK_Persona_Parametro] FOREIGN KEY([IdParametro])
REFERENCES [dbo].[Parametro] ([IdParametro])
GO
ALTER TABLE [dbo].[Persona] CHECK CONSTRAINT [FK_Persona_Parametro]
GO
ALTER TABLE [dbo].[Producto]  WITH CHECK ADD  CONSTRAINT [FK_Producto_Parametro] FOREIGN KEY([IdParametro])
REFERENCES [dbo].[Parametro] ([IdParametro])
GO
ALTER TABLE [dbo].[Producto] CHECK CONSTRAINT [FK_Producto_Parametro]
GO
ALTER TABLE [dbo].[Proveedor]  WITH CHECK ADD  CONSTRAINT [FK_Proveedor_Persona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[Persona] ([IdPersona])
GO
ALTER TABLE [dbo].[Proveedor] CHECK CONSTRAINT [FK_Proveedor_Persona]
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [FK_Usuario_Parametro] FOREIGN KEY([IdParametro])
REFERENCES [dbo].[Parametro] ([IdParametro])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [FK_Usuario_Parametro]
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [FK_Usuario_Persona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[Persona] ([IdPersona])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [FK_Usuario_Persona]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_Venta_Cliente] FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_Venta_Cliente]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_Venta_Usuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[Usuario] ([IdUsuario])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_Venta_Usuario]
GO
/****** Object:  StoredProcedure [dbo].[BuscarCliente]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[BuscarCliente](@IdCliente CHAR (50))
AS
	BEGIN
		SELECT* FROM Cliente WHERE IdCliente=@IdCliente;
	END
GO
/****** Object:  StoredProcedure [dbo].[BuscarPersona]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[BuscarPersona](@IdPersona CHAR(50))
AS
	BEGIN
		SELECT P.IdPersona,P.Nombre,P.Apellido,P.NumeroDocumento,P.Celular,P.Correo,P.Genero,P.FechaNacimiento,P.Direccion,P.IdParametro,P.Estado
		FROM Persona AS P WHERE IdPersona=@IdPersona;
	END
GO
/****** Object:  StoredProcedure [dbo].[BuscarUsuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[BuscarUsuario](@IdUsuario CHAR(50))
AS
	BEGIN
		SELECT U.Sueldo,U.Password,U.TipoContrato_P,U.Estado,U.Estado  FROM Usuario AS U WHERE IdUsuario =@IdUsuario;
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoCliente]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoCliente]
AS
	BEGIN
		SELECT COUNT(*)+1 FROM Cliente;
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoOrden]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoOrden]
AS
	BEGIN
		SELECT COUNT(*)+1 FROM OrdenCompra;
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoParametro]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoParametro]
AS
	BEGIN
		SELECT COUNT(*)+1 FROM Parametro;
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoPersona]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoPersona] 
AS
	BEGIN
		SELECT COUNT(*)+1 FROM Persona	
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoProducto]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoProducto]
AS
	BEGIN
		SELECT COUNT(*)+1 FROM Producto;
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoProveedor]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoProveedor]
AS
	BEGIN
	SELECT COUNT(*)+1 FROM Proveedor; 
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoUsuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoUsuario]
AS
	BEGIN
		SELECT COUNT(*)+1 FROM Usuario;
	END
GO
/****** Object:  StoredProcedure [dbo].[CodigoVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CodigoVenta]
AS
	BEGIN
		SELECT COUNT(*)+1 FROM Venta;
	END
GO
/****** Object:  StoredProcedure [dbo].[CompraProveedor]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CompraProveedor] (@Codigo CHAR(50))
AS
		DECLARE @IdPersona CHAR(50)
		SELECT @IdPersona = P.IdPersona FROM Proveedor AS P WHERE P.IdProveedor = @Codigo
	BEGIN
		SELECT P.Nombre,P.Apellido,P.Direccion,P.NumeroDocumento FROM Persona AS P WHERE P.IdPersona = @IdPersona;
	END
GO
/****** Object:  StoredProcedure [dbo].[Delete_Usuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Delete_Usuario](@IdUsuario CHAR(50))
AS
	BEGIN
		DELETE Usuario WHERE IdUsuario = @IdUsuario;
	END
GO
/****** Object:  StoredProcedure [dbo].[DeleteCliente]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteCliente](@IdCliente CHAR(50))
AS
	BEGIN
		DELETE Cliente WHERE IdCliente = @IdCliente;
	END
GO
/****** Object:  StoredProcedure [dbo].[DeleteDetalleVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteDetalleVenta](@IdDetalleVenta CHAR(50))
AS
	BEGIN
		DELETE DetalleVenta WHERE IdDetalleVenta=@IdDetalleVenta;
	END
GO
/****** Object:  StoredProcedure [dbo].[DeleteOrdenCompra]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteOrdenCompra](@IdOprdenCompra CHAR(50))
AS
	BEGIN
		DELETE OrdenCompra WHERE IdOrdenCompra=@IdOprdenCompra;
	END
GO
/****** Object:  StoredProcedure [dbo].[DeleteParametro]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteParametro](@IdParametro CHAR (50))
AS
	BEGIN
		DELETE Parametro WHERE Parametro.IdParametro=@IdParametro
	END
GO
/****** Object:  StoredProcedure [dbo].[DeletePersona]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeletePersona](@IdPersona char(50))
AS
	BEGIN
		DELETE Persona WHERE Persona.IdPersona=@IdPersona;
	END
GO
/****** Object:  StoredProcedure [dbo].[DeleteProducto]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteProducto](@IdProducto CHAR(50))
AS
	BEGIN
		DELETE Producto WHERE IdProducto = @IdProducto;
	END
GO
/****** Object:  StoredProcedure [dbo].[DeleteProveedor]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteProveedor](@IdProveedor CHAR(50))
AS
	BEGIN
		DELETE Proveedor WHERE IdProveedor=@IdProveedor;
	END
GO
/****** Object:  StoredProcedure [dbo].[DeleteVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteVenta](@IdVenta CHAR(50))
AS
	BEGIN
		DELETE Venta WHERE IdVenta=@IdVenta;
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertCliente]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertCliente](@IdCliente CHAR(50),@IdPersona CHAR(50),@FechaInicio DATETIME,@Observaciones NCHAR(300),@Estado BIT)
AS
	BEGIN
		INSERT INTO Cliente(IdCliente,IdPersona,FechaInicio,Observaciones,Estado) VALUES(@IdCliente,@IdPersona,@FechaInicio,@Observaciones,@Estado);
	END

GO
/****** Object:  StoredProcedure [dbo].[InsertDetalleCompra]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertDetalleCompra](@IdOrdenCompra CHAR(50),@IdProducto CHAR(50),@Cantidad INT,@PrecioCompra DECIMAL(18,3),@Total DECIMAL(18,4))
AS
	BEGIN
		INSERT INTO DetalleOrdenCompra(IdOrdenCompra,IdProducto,Cantidad,PrecioCompra,ImporteTotal) VALUES(@IdOrdenCompra,@IdProducto,@Cantidad,@PrecioCompra,@Total);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertDetalleVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertDetalleVenta](@IdVenta CHAR (50),@IdProducto CHAR(50),@Cantidad INT,@Descuento DECIMAL(11,3),@ImporteTotal DECIMAL(18,3))
AS
	BEGIN
		INSERT INTO DetalleVenta(IdVenta,IdProducto,Cantidad,Descuento,ImporteTotal) VALUES(@IdVenta,@IdProducto,@Cantidad,@Descuento,@ImporteTotal);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertOrdenCompra]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertOrdenCompra](@IdOrdenCompra CHAR(50),@MontoTotal DECIMAL(15,3),@IdProveedor CHAR(50),@IdParametro CHAR(50),@Estado BIT)
AS
	BEGIN
		INSERT INTO OrdenCompra(IdOrdenCompra,MontoTotal,IdProveedor,IdParametro,Estado)
			VALUES(@IdOrdenCompra,@MontoTotal,@IdProveedor,@IdParametro,@Estado);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertParametro]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertParametro](@IdParametro CHAR(50),@Descripcion NCHAR(30),@Tipo CHAR(50),@Estado bit)
AS
	BEGIN
		INSERT INTO Parametro(IdParametro,DescripcionP,TipoP,Estado) VALUES(@IdParametro,@Descripcion,@Tipo,@Estado);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertPersona]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertPersona](@IdPersona CHAR(50),@Nombre NCHAR(30),@Apellido NCHAR(60),@NumeroDoc NCHAR(10),
 @Celular NCHAR(9),@Correo NCHAR(30),@Genero BIT,@FechaNacimineto DATETIME,@Direccion NCHAR(250),@IdParametro CHAR(50),@Estado BIT)
AS
	BEGIN
		INSERT INTO Persona(IdPersona,Nombre,Apellido,NumeroDocumento,Celular,Correo,Genero
		,FechaNacimiento,Direccion,IdParametro,Estado) VALUES(@IdPersona,@Nombre,@Apellido,@NumeroDoc
		,@Celular,@Correo,@Genero,@FechaNacimineto,@Direccion,@IdParametro,@Estado);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertProducto]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertProducto](@IdProducto CHAR(50),@Nombre NCHAR(50),@Estado BIT,@Stock INT,@PrecioVenta DECIMAL(18,3),@IdParametro CHAR(50))
AS
	BEGIN
		INSERT INTO Producto(IdProducto,Nombre,Estado,Stock,Precio_Venta,IdParametro) VALUES(@IdProducto,@Nombre,@Estado,@Stock,@PrecioVenta,@IdParametro);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertProveedor]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertProveedor](@IdProveedor CHAR(50),@IdPersona CHAR(50),@Observaciones NCHAR(150),@Referencias NCHAR(150),@Estado BIT)
AS
	BEGIN
		INSERT INTO Proveedor(IdProveedor,IdPersona,Observaciones,Referencias,Estado) VALUES(@IdProveedor,@IdPersona,@Observaciones,@Referencias,@Estado);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertUsuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertUsuario](@IdUsuario CHAR(50),@IdPersona CHAR(50),@Sueldo DECIMAL(18,3),@Password CHAR(10),@IdParametro CHAR(50),@Estado BIT)
AS
	BEGIN
		INSERT INTO Usuario(IdUsuario,IdPersona,Sueldo,Password,IdParametro,Estado) VALUES(@IdUsuario,@IdPersona,@Sueldo,@Password,@IdParametro,@Estado);
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertVenta](@IdVenta CHAR(50),@IdUsuario CHAR(50),@IdCliente CHAR (50),@Fecha DATETIME,@TipoComprovante NCHAR(20),@MontoTotal DECIMAL(18,3),@Impuesto DECIMAL(10,3),@Estado BIT)
AS
	BEGIN
		INSERT INTO Venta(IdVenta,IdUsuario,IdCliente,Fecha,TipoComprovante,MontoTotal,Impuesto,Estado) VALUES(@IdVenta,@IdUsuario,@IdCliente,@Fecha,@TipoComprovante,@MontoTotal,@Impuesto,@Estado)
	END
GO
/****** Object:  StoredProcedure [dbo].[InsertVentaInicial]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertVentaInicial](@IdVenta CHAR(50),@IdUsuario CHAR (50),@IdCliente CHAR(50),@Fecha DATETIME,@TipoComprovante nchar(20))
AS
	BEGIN
		INSERT INTO Venta(IdVenta,IdUsuario,IdCliente,Fecha,TipoComprovante,Estado) VALUES(@IdVenta,@IdUsuario,@IdCliente,@Fecha,@TipoComprovante,1);
	END
GO
/****** Object:  StoredProcedure [dbo].[Logeo]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Logeo](@Usuario CHAR (50),@Password CHAR(10),@Categoria CHAR(50),@Token INT OUTPUT)
AS
	BEGIN
		DECLARE @CategoriaVerificacion CHAR(50);
		DECLARE @Estado BIT;
		DECLARE @PasswordVerificacion CHAR(10);
		SELECT @PasswordVerificacion = Password,@CategoriaVerificacion=TipoContrato_P,@Estado=Estado FROM Usuario WHERE IdUsuario = @Usuario;
		IF(@Estado=1 AND @PasswordVerificacion = @Password AND @CategoriaVerificacion=@Categoria)
			BEGIN
			--	RETURN (SELECT Estado FROM Usuario WHERE IdUsuario=@Usuario);	
			---	SELECT Nombre FROM Persona WHERE IdPersona=@IdPersona;
			SELECT @Token=1;
			END
		ELSE
			BEGIN
				SELECT @Token=0;
			END
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateCliente]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateCliente](@IdCliente CHAR(50),@FechaInicio DATETIME,@Observaciones NCHAR(300),@Estado BIT)
AS
	BEGIN
		update Cliente SET FechaInicio=@FechaInicio,Observaciones=@Observaciones,Estado=@Estado WHERE IdCliente=@IdCliente;
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateDetalleVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateDetalleVenta](@IdVenta CHAR (50),@IdProducto CHAR(50),@Cantidad INT,@Descuento DECIMAL(11,3),@ImporteTotal DECIMAL(18,3))
AS
	BEGIN
		UPDATE DetalleVenta SET Cantidad=@Cantidad,Descuento=@Descuento,ImporteTotal= @ImporteTotal WHERE IdVenta = @IdVenta AND IdProducto = @IdProducto;
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateOrdenCompra]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateOrdenCompra](@IdOrdenCompra CHAR(50),@MontoTotal DECIMAL(15,3),@Fecha DATETIME,@IdProveedor CHAR(50),@Estado BIT)
AS
	BEGIN
		UPDATE OrdenCompra SET MontoTotal=@MontoTotal,fecha=@Fecha,IdProveedor=@IdProveedor,Estado=@Estado WHERE IdOrdenCompra=@IdOrdenCompra;
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateParametro]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateParametro](@IdParametro CHAR(50),@Descripcion NCHAR(30),@Tipo CHAR(50),@Estado bit)
AS
	BEGIN
		update Parametro SET DescripcionP=@Descripcion,TipoP=@Tipo,Estado=@Estado WHERE IdParametro=@IdParametro
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdatePersona]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdatePersona](@IdPersona CHAR(50),@Nombre NCHAR(30),@Apellido NCHAR(60),@NumeroDoc NCHAR(10),
 @Celular NCHAR(9),@Correo NCHAR(30),@Genero BIT,@FechaNacimineto DATETIME,@Direccion NCHAR(250),@IdParametro CHAR(50),@Estado BIT)
AS
	BEGIN
		UPDATE Persona SET Nombre=@Nombre,Apellido =@Apellido,NumeroDocumento=@NumeroDoc,Celular=@Celular,Correo=@Correo,Genero = @Genero,FechaNacimiento=@FechaNacimineto
		,Direccion=@Direccion,Estado=@Estado WHERE IdPersona=@IdPersona;
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateProducto]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateProducto](@IdProducto CHAR(50),@Nombre NCHAR(50),@Estado BIT,@Stock INT,@Precio Decimal(18,3))
AS
	BEGIN
		UPDATE Producto SET Nombre=@Nombre,Estado=@Estado,Stock=@Stock, Precio_Venta=@Precio WHERE IdProducto=@IdProducto;
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateProveedor]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateProveedor](@IdProveedor CHAR(50),@IdPersona CHAR(50),@Observaciones NCHAR(150),@Referencias NCHAR(150),@Estado BIT)
AS
	BEGIN
		UPDATE Proveedor SET IdPersona=@IdPersona,Observaciones=@Observaciones,Referencias=@Referencias,Estado=@Estado where IdProveedor=@IdProveedor;
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateUsuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateUsuario](@IdUsuario CHAR(50),@Sueldo DECIMAL(18,3),@Password CHAR(10),@IdParametro CHAR(50),@Estado BIT)
AS
	BEGIN
		UPDATE Usuario SET Sueldo = @Sueldo,Password=@Password,IdParametro=@IdParametro,Estado=@Estado WHERE IdUsuario=@IdUsuario;
	END
GO
/****** Object:  StoredProcedure [dbo].[UpdateVenta]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateVenta](@IdVenta CHAR(50),@IdUsuario CHAR(50),@IdCliente CHAR (50),@Fecha DATETIME,@TipoComprovante NCHAR(20),@MontoTotal DECIMAL(18,3),@Impuesto DECIMAL(10,3),@Estado BIT)
AS
	BEGIN
		UPDATE Venta SET IdUsuario = @IdUsuario,IdCliente=@IdCliente,Fecha=@Fecha,TipoComprovante=@TipoComprovante,MontoTotal=@MontoTotal,Impuesto=@Impuesto,Estado=@Estado WHERE IdVenta= @IdVenta;
	END
GO
/****** Object:  StoredProcedure [dbo].[VentaCliente]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[VentaCliente](@IdCliente CHAR(50))
AS
	DECLARE @IdPersona CHAR (50)
	SELECT @IdPersona=C.IdPersona FROM Cliente AS C WHERE IdCliente = @IdCliente;
	BEGIN
		SELECT P.Nombre,P.Apellido,P.Direccion,P.NumeroDocumento FROM  Persona AS P WHERE IdPersona = @IdPersona;
	END
GO
/****** Object:  StoredProcedure [dbo].[VentaUsuario]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[VentaUsuario](@IdCliente CHAR(50))
AS
	DECLARE @IdPersona CHAR (50)
	SELECT @IdPersona=C.IdPersona FROM Usuario AS C WHERE IdUsuario = @IdCliente;
	BEGIN
		SELECT P.Nombre,P.Apellido,P.Direccion,P.NumeroDocumento FROM  Persona AS P WHERE IdPersona = @IdPersona;
	END
GO
/****** Object:  StoredProcedure [dbo].[ViewDetalleCompra2]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ViewDetalleCompra2](@Codigo CHAR (50))
AS
	BEGIN
		SELECT D.IdProducto,P.Nombre,d.Cantidad,D.PrecioCompra,D.ImporteTotal FROM DetalleOrdenCompra AS D INNER JOIN Producto AS P on D.IdProducto=P.IdProducto WHERE D.IdOrdenCompra=@Codigo;
	END
GO
/****** Object:  StoredProcedure [dbo].[ViewDetalleVenta2]    Script Date: 4/11/2023 11:17:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ViewDetalleVenta2](@IdVenta CHAR(50))
AS
	BEGIN
			SELECT Det.IdProducto,P.Nombre,Det.Cantidad,Det.Descuento,Det.ImporteTotal FROM DetalleVenta AS Det
			INNER JOIN Producto AS P ON Det.IdProducto = P.IdProducto WHERE Det.IdVenta=@IdVenta;
	END
GO
